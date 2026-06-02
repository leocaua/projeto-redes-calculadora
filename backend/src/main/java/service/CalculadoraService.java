package service;

import dto.RedeDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public RedeDTO calcular(String ip, int cidr) {
        String[] partesIp = ip.split("\\.");
        int[] octetosIp = new int[4];
        for (int i = 0; i < 4; i++) {
            octetosIp[i] = Integer.parseInt(partesIp[i]);
        }


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


        int[] primeiroIp = octetosRede.clone();
        primeiroIp[3] += 1;

        int[] ultimoIp = octetosBroadcast.clone();
        ultimoIp[3] -= 1;


        long totalHosts = (long) Math.pow(2, 32 - cidr) - 2;
        if (cidr >= 31) totalHosts = 0;


        String classeIp = "Indefinida";
        if(octetosIp[0] >= 1 && octetosIp[0] <= 126) classeIp = "A";
        else if (octetosIp[0] >= 128 && octetosIp[0] <= 191) classeIp = "B";
        else if (octetosIp[0] >= 192 && octetosIp[0] <= 223)  classeIp = "C";

        return new RedeDTO(
                ip,
                formatarIp(octetosMascara),
                "/" + cidr,
                formatarIp(octetosRede),
                formatarIp(octetosBroadcast),
                formatarIp(primeiroIp),
                formatarIp(ultimoIp),
                totalHosts,
                classeIp
        );
    }

    private String formatarIp(int[] octetos) {
        return octetos[0] + "." + octetos[1] + "." + octetos[2] + "." + octetos[3];
    }
}
