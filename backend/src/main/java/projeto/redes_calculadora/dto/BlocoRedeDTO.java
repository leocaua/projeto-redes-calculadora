package projeto.redes_calculadora.dto;

public class BlocoRedeDTO {
    private int numero;
    private String enderecoRede;
    private String enderecoBroadcast;
    private String primeiroIpValido;
    private String ultimoIpValido;
    private long quantidadeHosts;
    private boolean contemIpInformado;

    public BlocoRedeDTO(int numero, String enderecoRede, String enderecoBroadcast,
                        String primeiroIpValido, String ultimoIpValido,
                        long quantidadeHosts, boolean contemIpInformado) {
        this.numero = numero;
        this.enderecoRede = enderecoRede;
        this.enderecoBroadcast = enderecoBroadcast;
        this.primeiroIpValido = primeiroIpValido;
        this.ultimoIpValido = ultimoIpValido;
        this.quantidadeHosts = quantidadeHosts;
        this.contemIpInformado = contemIpInformado;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
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
    public boolean isContemIpInformado() {
        return contemIpInformado;
    }
    public void setContemIpInformado(boolean contemIpInformado) {
        this.contemIpInformado = contemIpInformado;
    }
}