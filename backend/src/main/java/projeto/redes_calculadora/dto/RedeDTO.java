package projeto.redes_calculadora.dto;

import java.util.List;

public class RedeDTO {
    private String ipInformado;
    private String mascaraSubrede;
    private String prefixoCidr;
    private String enderecoRede;
    private String enderecoBroadcast;
    private String primeiroIpValido;
    private String ultimoIpValido;
    private long quantidadeHosts;
    private String classeIp;
    private List<BlocoRedeDTO> blocos;

    public RedeDTO(String ipInformado, String mascaraSubrede, String prefixoCidr,
                   String enderecoRede, String enderecoBroadcast, String primeiroIpValido,
                   String ultimoIpValido, long quantidadeHosts, String classeIp,
                   List<BlocoRedeDTO> blocos) {
        this.ipInformado = ipInformado;
        this.mascaraSubrede = mascaraSubrede;
        this.prefixoCidr = prefixoCidr;
        this.enderecoRede = enderecoRede;
        this.enderecoBroadcast = enderecoBroadcast;
        this.primeiroIpValido = primeiroIpValido;
        this.ultimoIpValido = ultimoIpValido;
        this.quantidadeHosts = quantidadeHosts;
        this.classeIp = classeIp;
        this.blocos = blocos;
    }

    public String getIpInformado() {
        return ipInformado;
    }
    public String getMascaraSubrede() {
        return mascaraSubrede;
    }
    public String getPrefixoCidr() {
        return prefixoCidr;
    }
    public String getEnderecoRede() {
        return enderecoRede;
    }
    public String getEnderecoBroadcast() {
        return enderecoBroadcast;
    }
    public String getPrimeiroIpValido() {
        return primeiroIpValido;
    }
    public String getUltimoIpValido() {
        return ultimoIpValido;
    }
    public long getQuantidadeHosts() {
        return quantidadeHosts;
    }
    public String getClasseIp() {
        return classeIp;
    }
    public List<BlocoRedeDTO> getBlocos() {
        return blocos;
    }
}