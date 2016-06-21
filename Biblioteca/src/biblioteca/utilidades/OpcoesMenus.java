/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.utilidades;

/**
 * Centralizador para as diversas opções de menu
 * @author demetrius
 */
public class OpcoesMenus {
    
    // Opcçoes para a Tela Inicial
    public static final int OP_CLIENTES = 1;
    public static final int OP_LIVROS = 2;
    public static final int OP_MOVIMENTACOES = 3;
    public static final int OP_RELATORIOS = 4;
    public static final int OP_SAIR = 5;
    
    
    // Opções para a Tela Clientes
    public static final int CLIENTE_OP_CADASTRAR = 1;
    public static final int CLIENTE_OP_LISTAR = 2;
    public static final int CLIENTE_OP_SELECIONAR = 3;
    public static final int CLIENTE_OP_LISTAR_EXCLUIDOS = 4;
    
    // Sub-menu de Cliente - Operações relacionadas a um cliente específico
    public static final int CLIENTE_SUB_EDITAR = 1;
    public static final int CLIENTE_SUB_EXCLUIR = 2;
    public static final int CLIENTE_SUB_VER_ANDAMENTO = 3;
    public static final int CLIENTE_SUB_VOLTAR = 4;
    
    public static final int CLIENTE_OP_VOLTAR = 5;
    
    // Opções para a Tela Livros
    public static final int LIVRO_OP_CADASTRAR = 1;
    public static final int LIVRO_OP_LISTAR = 2;
    public static final int LIVRO_OP_SELECIONAR = 3;
    
    public static final int LIVRO_SUB_EDITAR = 1;
    public static final int LIVRO_SUB_EXCLUIR = 2;
    public static final int LIVRO_SUB_VOLTAR = 3;
    
    public static final int LIVRO_OP_VOLTAR = 4;
    
    // Opções para a Tela Movimentos
    public static final int MOV_OP_RETIRAR = 1;
    public static final int MOV_OP_DEVOLVER = 2;
    public static final int MOV_OP_CONSULTAR = 3;
    public static final int MOV_OP_SELECIONAR = 4;
    
    public static final int MOV_SUB_DEVOLVER_TODOS = 1;
    public static final int MOV_SUB_VERIFICAR_PENDENTES = 2;
    public static final int MOV_SUB_VOLTAR = 3;
        
    public static final int MOV_OP_VOLTAR = 5;
    
    // Opções para a Tela Relatórios
    public static final int REL_OP_LIVROS_DISP = 1;
    public static final int REL_OP_LIVROS_INDISP = 2;
    public static final int REL_OP_CLIENTE_ULT_RETIR = 3;
    public static final int REL_OP_ULT_RETIR = 4;
    public static final int REL_OP_ULT_DEV = 5;
    public static final int REL_OP_VOLTAR = 6;
    
}
