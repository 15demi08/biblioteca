/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.controladores;

import biblioteca.modelos.Cliente;
import biblioteca.modelos.Livro;
import biblioteca.modelos.Movimentacao;
import biblioteca.repositorios.Repositorio;
import biblioteca.repositorios.RepositorioClientes;
import biblioteca.repositorios.RepositorioLivros;
import biblioteca.repositorios.RepositorioMovimentacoes;
import biblioteca.utilidades.Console;
import java.util.ArrayList;

/**
 *
 * @author 631510058
 */
public class RetirarLivro {

    public static void executar() {

        Repositorio<Movimentacao> repMovs = RepositorioMovimentacoes.getInstancia();

        int matriculaCliente, codLivro; // Códigos a pesquisar
        Cliente cliente = null; // Cliente que está retirando
        ArrayList<Livro> livros = new ArrayList<>(); // Livros sendo retirados

        // Pesquisar Cliente
        do {

            cliente = solicitaCliente();

            if (cliente == null) {
                Console.println("-- Cliente não encontrado!");
            }

        } while (cliente == null);

        // Inserir Livros
        livros = solicitaLivros();

        String confirma;
        boolean respondido = false;

        do {

            confirma = Console.readString("-- Confirma? (s/n)");

            switch (confirma) {

                case "s":
                    // Criar Movimentação
                    Movimentacao m = new Movimentacao(cliente, livros);

                    // Movimentar livros
                    for (Livro l : livros) {
                        l.movimentar(Livro.STATUS_INDISPONIVEL);
                    }

                    // Registrar Movimentação
                    repMovs.adicionar(m);

                    // Mensagem
                    Console.println("-- Movimentação registrada!");
                    Console.println(m);

                    respondido = true;

                    break;
                case "n":
                    respondido = true;
                    break;
                default:
                    Console.println("Opção Inválida!");
                    break;

            }

        } while (!respondido);

    }

    private static Cliente solicitaCliente() {

        Repositorio<Cliente> repClientes = RepositorioClientes.getInstancia();

        int matriculaCliente = Console.readInt("-- Matrícula do Cliente:");

        for (int i = 0; i < repClientes.numItens(); i++) {

            Cliente cliente = repClientes.retornar(i);

            if (cliente.getMatricula() == matriculaCliente) {
                return cliente;
            }
        }

        return null;

    }

    private static ArrayList<Livro> solicitaLivros() {

        ArrayList<Livro> livros = new ArrayList<>();

        int contadorLivros = 0;

        Livro livro;

        do {

            livro = solicitaLivro();

            if (livro == null) {
                
                Console.println("-- Livro não encontrado!");
                
            } else {
                
                if( livros.contains(livro) ){
                    
                    Console.println("-- Livro já está na retirada!");
                    
                } else {
                    
                    livros.add(livro);
                
                    Console.println("-- Livro adicionado: " + livro.getNome());

                    switch (Console.readString("-- Adicionar outro livro? (s/n)")) {

                        case "s":
                            contadorLivros++;
                            break;
                        case "n":
                            contadorLivros = 3;
                            break;
                        default:
                            Console.println("Opção Inválida!");
                            break;

                    }
                    
                }
                
            }

        } while (contadorLivros != 3);

        return livros;

    }

    private static Livro solicitaLivro() {

        Repositorio<Livro> repLivros = RepositorioLivros.getInstancia();

        boolean teste = false;
        
        do {
            
            try {
                
                int codigoLivro = Integer.parseInt(Console.readString("-- Código do Livro:"));

                for (int i = 0; i < repLivros.numItens(); i++) {

                    Livro l = repLivros.retornar(i);

                    if (l.getCodigo() == codigoLivro) {
                        teste = true;
                        return l;
                    }

                }
                
            } catch(NumberFormatException e){
                Console.println("Apenas Números!");
            }
            
        } while (!teste);

        return null;

    }

}
