package g2tde;

import java.io.*;
import java.util.*;

public class ArquivoUtil {
    private static final String FILE_NAME = "automoveis.txt";

    public static void salvar(List<Automovel> lista) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Automovel a : lista) {
            bw.write(a.toString());
            bw.newLine();
        }
        bw.close();
    }

    public static List<Automovel> carregar() throws IOException {
        List<Automovel> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha;
        while ((linha = br.readLine()) != null) {
            lista.add(Automovel.fromString(linha));
        }
        br.close();
        return lista;
    }
}
