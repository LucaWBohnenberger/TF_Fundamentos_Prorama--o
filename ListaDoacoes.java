/**
 * Implemente a classe Lista de Doações. Defina os seguintes métodos necessárias
 * para manipular essa lista. - método que cadastra uma Doação. Só podem ser
 * criadas novas doações quando estas ainda não tenham sido cadastradas; -
 * método que consulta uma doação pelo nome dado ao item; - método que adiciona
 * quantidades de itens para uma doação já existente; - método que retorna todas
 * as doações que tem um número maior ou igual a X de itens na lista; - método
 * que retira itens de uma determinada doação. - método que imprime todas as
 * doações;
 *
 * @author Gabriel Domingues and Luca WB
 * @version 06/07/2024
 */
public class ListaDoacoes {

    private Doacao[] listaDoacoes;
    private int index;
    private final int tamanho;

    public ListaDoacoes() {
        tamanho = 10;
        listaDoacoes = new Doacao[tamanho];
        index = 0;
    }

    public boolean cadastraDoacao(Doacao d) {
        if (index == 0) {
            listaDoacoes[index] = d;
            index++;
            return true;
        }

        if (index == tamanho) {
            listaDoacoes = listaInfinita();
        }

        for (int i = 0; i < index; i++) {
            if (listaDoacoes[i].getCodigoDaDoacao().equals(d.getCodigoDaDoacao())) {
                return false;
            }
        }

        listaDoacoes[index] = d;
        index++;
        return true;
    }

    private Doacao[] listaInfinita() {
        Doacao[] listaNova = new Doacao[tamanho * 2];
        for (int i = 0; i < index; i++) {
            listaNova[i] = listaDoacoes[i];
        }
        return listaNova;
    }

    public Doacao buscaDoacaoPorDescricao(String descricao) {
        descricao = descricao.toLowerCase();
        for (int i = 0; i < index; i++) {
            if (listaDoacoes[i].getDescricao().toLowerCase().equals(descricao)) {
                return listaDoacoes[i];
            }
        }
        return null;
    }

    public Doacao buscaDoacaoPorCodigo(String codigo) {
        for (int i = 0; i < index; i++) {
            if (listaDoacoes[i].getCodigoDaDoacao().equals(codigo)) {
                return listaDoacoes[i];
            }
        }
        return null;
    }

    public boolean adicionaQuantidade(String codigo, int quantidade) {
        if (quantidade <= 0) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (listaDoacoes[i].getCodigoDaDoacao().equals(codigo)) {
                listaDoacoes[i].setQuantidade(listaDoacoes[i].getQuantidade() + quantidade);
                return true;
            }
        }
        return false;
    }

    public Doacao[] retornaDoacoesXItens(int quantidade) {
        Doacao[] doacoesMaiorQueX = new Doacao[index];
        for (int i = 0; i < index; i++) {
            if (listaDoacoes[i].getQuantidade() > quantidade) {
                doacoesMaiorQueX[i] = listaDoacoes[i];
            }
        }
        return doacoesMaiorQueX;
    }

    public String listarMaiorQue(int quantidade){
        Doacao[] lista = retornaDoacoesXItens(quantidade);
        String retorno = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                retorno += lista[i].toString() + "\n";
            }
        }
        return retorno;
    }



    public boolean removeQuantidade(String codigo, int quantidade) {
        if (quantidade <= 0) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (listaDoacoes[i].getCodigoDaDoacao().equals(codigo)) {
                listaDoacoes[i].setQuantidade(listaDoacoes[i].getQuantidade() - quantidade);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String retorno = "";
        for (int i = 0; i < index; i++) {
            retorno = retorno + listaDoacoes[i].toString();
        }
        return retorno;
    }
}