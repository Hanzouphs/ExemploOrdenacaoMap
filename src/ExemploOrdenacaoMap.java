import java.util.*;

public class ExemploOrdenacaoMap {
        public static void main(String[] args) throws Exception {

        System.out.println("---\tOrdem aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>() {{
            put("Dale Carnegie", new Livro("Como  fazer amigos e influenciar pessoas", 256));
            put("Duhig Charles", new Livro("O Poder do Hábito", 408));
            put("Robert Greene", new Livro("48 Leis D Poder", 544));
        }};
        for (Map.Entry<String, Livro> livro: meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
            
        }

        System.out.println("");
        
        System.out.println("---\tOrdem Inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
            put("Dale Carnegie", new Livro("Como  fazer amigos e influenciar pessoas", 256));
            put("Duhig Charles", new Livro("O Poder do Hábito", 408));
            put("Robert Greene", new Livro("48 Leis D Poder", 544));
        }};
        for (Map.Entry<String, Livro> livro: meusLivros1.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
            
        }
        
        System.out.println("");
        
        System.out.println("---\tOrdem alfabética autores\t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros);
        for (Map.Entry<String, Livro> livro: meusLivros2.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
            
        }

        System.out.println("");
        
        System.out.println("---\tOrdem alfabética nome dos livros\t--");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro: meusLivros3){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
            
        }


    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas){
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome(){
        return nome;
    }

    public Integer getPaginas(){
        return paginas;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString(){
        return "Livro{"+
                "nome='" + nome + '\''+
                ", paginas =" + paginas +
                '}';
    }

}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2){
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}