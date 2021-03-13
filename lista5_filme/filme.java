package lista5_filme;

public class filme {
    private int code;
    private String name;
    private String gen;

    public filme(int code, String name, String gen) {
        this.code = code;
        this.name = name;
        this.gen = gen;
    }
   
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getGen() {
        return gen;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("filme{code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", gen=").append(gen);
        sb.append('}');
        return sb.toString();
    }  
}
