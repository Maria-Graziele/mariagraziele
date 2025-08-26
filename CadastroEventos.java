package com.mycompany.mavenproject2;

import java.util.Scanner;

class Usuario {
    private final String nome;
    private final String endereco;
    private final String email;
    
    public Usuario(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public String getEndereco() { 
        return endereco; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public String toString() {
        return nome + " (" + email + ")";
    }
    
    public void mostrarUsuario() {
        System.out.println("\n--- Dados do Usuario ---");
        System.out.println("Nome: " + nome);
        System.out.println("Endereco: " + endereco);
        System.out.println("Email: " + email);
    }
}

class Evento {
    private final String nome;
    private final String endereco;
    
    public Evento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void mostrarEvento() {
        System.out.println("\n--- Detalhes do Evento ---");
        System.out.println("Nome: " + nome);
        System.out.println("Endereco: " + endereco);
    }
}

public class CadastroEventos {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("=== Sistema de Cadastro de Eventos e Usuarios ===\n");
            
            Usuario usuario = cadastrarUsuario(sc);
        
            Evento evento = selecionarEvento(sc);
            
            exibirResumo(usuario, evento);
            
        } catch (Exception e) {
            System.out.println("Erro no sistema: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
    
    private static Usuario cadastrarUsuario(Scanner sc) {
        System.out.println("--- CADASTRO DE USUARIO ---");
        
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Digite o endereco: ");
        String endereco = sc.nextLine();
        
        System.out.print("Digite o email: ");
        String email = sc.nextLine();
        
        Usuario usuario = new Usuario(nome, endereco, email);
        System.out.println("Usuario cadastrado com sucesso!\n");
        
        return usuario;
    }
    
    private static Evento selecionarEvento(Scanner sc) {
        System.out.println("--- SELECAO DE EVENTO ---");
        System.out.println("1 - Usar evento fixo (Feira Noturna de Ibiuna)");
        System.out.println("2 - Cadastrar evento personalizado");
        System.out.print("Escolha uma opcao (1 ou 2): ");
        
        int opcao = sc.nextInt();
        sc.nextLine();
        
        Evento evento;
        
        if (opcao == 1) {
            evento = new Evento("Feira Noturna de Ibiuna", "Centro da cidade - Ibiuna/SP");
            System.out.println("Evento fixo selecionado!\n");
        } else if (opcao == 2) {
            System.out.print("Digite o nome do evento: ");
            String nome = sc.nextLine();
            
            System.out.print("Digite o endereco do evento: ");
            String endereco = sc.nextLine();
            
            evento = new Evento(nome, endereco);
            System.out.println("Evento cadastrado com sucesso!\n");
        } else {
            System.out.println("Opcao invalida! Usando evento padrao.\n");
            evento = new Evento("Feira Noturna de Ibiuna", "Centro da cidade - Ibiuna/SP");
        }
        
        return evento;
    }
    
    private static void exibirResumo(Usuario usuario, Evento evento) {
        System.out.println("==================================================");
        System.out.println("         RESUMO DO CADASTRO");
        System.out.println("==================================================");
        
        usuario.mostrarUsuario();
        evento.mostrarEvento();
        
        System.out.println("\n==================================================");
        System.out.println("Cadastro finalizado com sucesso!");
        System.out.println("==================================================");
    }
}
