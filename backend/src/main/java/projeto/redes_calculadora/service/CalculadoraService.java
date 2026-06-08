package projeto.redes_calculadora.service;

import projeto.redes_calculadora.dto.BlocoRedeDTO;
import projeto.redes_calculadora.dto.RedeDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraService {

    public RedeDTO calcular(String ip, String mascaraInput) {
        int cidr = converterMascaraParaCidr(mascaraInput);

        String[] partesIp = ip.split("\\.");
        int[] octetosIp = new int[4];
        for (int i = 0; i < 4; i++) { octetosIp[i] = Integer.parseInt(partesIp[i]); }

        int[] octetosMascara = new int[4];
        long mascaraCompleta = (0xFFFFFFFFL << (32 - cidr)) & 0xFFFFFFFFL;
        octetosMascara[0] = (int) (mascaraCompleta >> 24) & 255;
        octetosMascara[1] = (int) (mascaraCompleta >> 16) & 255;
        octetosMascara[2] = (int) (mascaraCompleta >> 8) & 255;
        octetosMascara[3] = (int) mascaraCompleta & 255;

        int[] octetosRede = new int[4];
        int[] octetosBroadcast =  new int[4];
        for (int i = 0; i < 4; i++) {
            octetosRede[i] = octetosIp[i] & octetosMascara[i];
            octetosBroadcast[i] = octetosRede[i] | (255 - octetosMascara[i]);
        }

        int[] primeiroIp = octetosRede.clone(); primeiroIp[3] += 1;
        int[] ultimoIp = octetosBroadcast.clone(); ultimoIp[3] -= 1;

        long totalHosts = (long) Math.pow(2, 32 - cidr) - 2;
        if (cidr >= 31) totalHosts = 0;

        String classeIp = "Indefinida";
        if(octetosIp[0] >= 1 && octetosIp[0] <= 126) classeIp = "A";
        else if (octetosIp[0] >= 128 && octetosIp[0] <= 191) classeIp = "B";
        else if (octetosIp[0] >= 192 && octetosIp[0] <= 223)  classeIp = "C";

        List<BlocoRedeDTO> listaBlocos = new ArrayList<>();
        int majorCidr = 24;
        if (classeIp.equals("A")) majorCidr = 8;
        else if (classeIp.equals("B")) majorCidr = 16;
        if (cidr < majorCidr) majorCidr = cidr;

        long ipLong = ipParaLong(ip);
        long majorMask = (0xFFFFFFFFL << (32 - majorCidr)) & 0xFFFFFFFFL;
        long majorNetworkAddr = ipLong & majorMask;

        int bitsSubrede = cidr - majorCidr;
        long numSubnets = 1L << bitsSubrede;
        long subnetSize = 1L << (32 - cidr);

        long startSubnet = 0;
        long endSubnet = numSubnets;
        if (numSubnets > 128) {
            long idxAtual = (ipLong - majorNetworkAddr) / subnetSize;
            startSubnet = Math.max(0, idxAtual - 64);
            endSubnet = Math.min(numSubnets, startSubnet + 128);
        }

        for (long s = startSubnet; s < endSubnet; s++) {
            long netLong = majorNetworkAddr + (s * subnetSize);
            long broadLong = netLong + subnetSize - 1;
            boolean contemIp = (ipLong >= netLong && ipLong <= broadLong);
            listaBlocos.add(new BlocoRedeDTO((int) (s + 1), longParaIp(netLong), longParaIp(broadLong), longParaIp(netLong + 1), longParaIp(broadLong - 1), totalHosts, contemIp));
        }

        return new RedeDTO(
                ip, formatarIp(octetosMascara), "/" + cidr, formatarIp(octetosRede),
                formatarIp(octetosBroadcast), formatarIp(primeiroIp), formatarIp(ultimoIp),
                totalHosts, classeIp, listaBlocos
        );
    }

    private String formatarIp(int[] octetos) {
        return octetos[0] + "." + octetos[1] + "." + octetos[2] + "." + octetos[3];
    }

    private int converterMascaraParaCidr(String mascaraInput) {
        mascaraInput = mascaraInput.replace("/", "").trim();
        if (!mascaraInput.contains("."))
            return Integer.parseInt(mascaraInput);
        int cidr = 0;
        for (String octeto : mascaraInput.split("\\.")) cidr += Integer.bitCount(Integer.parseInt(octeto));
        return cidr;
    }

    private long ipParaLong(String ipStr) {
        long num = 0;
        for (String p : ipStr.split("\\.")) num = (num << 8) | Integer.parseInt(p);
        return num;
    }
    private String longParaIp(long ipLong) {
        return ((ipLong >> 24) & 0xFF) + "." + ((ipLong >> 16) & 0xFF) + "." + ((ipLong >> 8) & 0xFF) + "." + (ipLong & 0xFF);
    }
}