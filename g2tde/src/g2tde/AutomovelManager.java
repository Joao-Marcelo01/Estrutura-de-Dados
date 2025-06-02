package g2tde;

import java.io.IOException;
import java.util.*;

public class AutomovelManager {
    private List<Automovel> lista;

    public AutomovelManager() {
        try {
            lista = ArquivoUtil.carregar();
        } catch (IOException e) {
            lista = new ArrayList<>();
        }
    }

    public boolean inserir(Automovel a) {
        if (buscar(a.getPlaca()) != null) return false;
        lista.add(a);
        return true;
    }

    public boolean remover(String placa) {
        return lista.removeIf(a -> a.getPlaca().equalsIgnoreCase(placa));
    }

    public boolean alterar(String placa, Automovel novo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPlaca().equalsIgnoreCase(placa)) {
                lista.set(i, novo);
                return true;
            }
        }
        return false;
    }

    public Automovel buscar(String placa) {
        for (Automovel a : lista) {
            if (a.getPlaca().equalsIgnoreCase(placa)) return a;
        }
        return null;
    }

    public List<Automovel> listar(String campo) {
        List<Automovel> copia = new ArrayList<>(lista);
        Comparator<Automovel> comp = switch (campo.toLowerCase()) {
            case "modelo" -> Comparator.comparing(Automovel::getModelo, String.CASE_INSENSITIVE_ORDER);
            case "marca" -> Comparator.comparing(Automovel::getMarca, String.CASE_INSENSITIVE_ORDER);
            default -> Comparator.comparing(Automovel::getPlaca, String.CASE_INSENSITIVE_ORDER);
        };
        copia.sort(comp);
        return copia;
    }

    public void salvar() {
        try {
            ArquivoUtil.salvar(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }
}
