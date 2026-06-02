package projeto.redes_calculadora.dto;

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

    public RedeDTO() {

    }

    public RedeDTO(String ipInformado, String mascaraSubrede, String prefixoCidr,
                   String enderecoRede, String enderecoBroadcast, String primeiroIpValido,
                   String ultimoIpValido, long quantidadeHosts, String classeIp) {

        this.ipInformado = ipInformado;
        this.mascaraSubrede = mascaraSubrede;
        this.prefixoCidr = prefixoCidr;
        this.enderecoRede = enderecoRede;
        this.enderecoBroadcast = enderecoBroadcast;
        this.primeiroIpValido = primeiroIpValido;
        this.ultimoIpValido = ultimoIpValido;
        this.quantidadeHosts = quantidadeHosts;
        this.classeIp = classeIp;
    }

    public String getIpInformado() {
        return ipInformado;
    }
    public void setIpInformado(String ipInformado) {
        this.ipInformado = ipInformado;
    }


    public String getMascaraSubrede() {
        return mascaraSubrede;
    }
    public void setMascaraSubrede(String mascaraSubrede) {
        this.mascaraSubrede = mascaraSubrede;
    }


    public String getPrefixoCidr() {
        return prefixoCidr;
    }
    public void setPrefixoCidr(String prefixoCidr) {
        this.prefixoCidr = prefixoCidr;
    }


    public String getEnderecoRede() {
        return enderecoRede;
    }
    public void setEnderecoRede(String enderecoRede) {
        this.enderecoRede = enderecoRede;
    }


    public String getEnderecoBroadcast() {
        return enderecoBroadcast;
    }
    public void setEnderecoBroadcast(String enderecoBroadcast) {
        this.enderecoBroadcast = enderecoBroadcast;
    }


    public String getPrimeiroIpValido() {
        return primeiroIpValido;
    }
    public void setPrimeiroIpValido(String primeiroIpValido) {
        this.primeiroIpValido = primeiroIpValido;
    }


    public String getUltimoIpValido() {
        return ultimoIpValido;
    }
    public void setUltimoIpValido(String ultimoIpValido) {
        this.ultimoIpValido = ultimoIpValido;
    }


    public long getQuantidadeHosts() {
        return quantidadeHosts;
    }
    public void setQuantidadeHosts(long quantidadeHosts) {
        this.quantidadeHosts = quantidadeHosts;
    }


    public String getClasseIp() {
        return classeIp;
    }
    public void setClasseIp(String classeIp) {
        this.classeIp = classeIp;
    }
}
