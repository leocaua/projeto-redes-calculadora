import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface BlocoRedeDTO {
  numero: number; enderecoRede: string; enderecoBroadcast: string;
  primeiroIpValido: string; ultimoIpValido: string; quantidadeHosts: number; contemIpInformado: boolean;
}

interface RedeDTO {
  ipInformado: string; mascaraSubrede: string; prefixoCidr: string;
  enderecoRede: string; enderecoBroadcast: string; primeiroIpValido: string;
  ultimoIpValido: string; quantidadeHosts: number; classeIp: string;
  blocos: BlocoRedeDTO[];
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  ipDigitado: string = ''; mascaraDigitada: string = '';
  resultadoDaAPI: RedeDTO | null = null; erroMsg: string = '';

  constructor(private http: HttpClient) {}

  calcularRede() {
    if (!this.ipDigitado || !this.mascaraDigitada) { this.erroMsg = 'Preencha os campos!'; return; }
    this.erroMsg = '';
    const url = `http://localhost:8080/api/calculadora/calcular?ip=${this.ipDigitado}&mascara=${encodeURIComponent(this.mascaraDigitada)}`;

    this.http.get<RedeDTO>(url).subscribe({
      next: (dados) => { this.resultadoDaAPI = dados; },
      error: () => { this.erroMsg = 'Valores inválidos ou servidor offline.'; this.resultadoDaAPI = null; }
    });
  }
}
