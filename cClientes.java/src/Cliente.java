class Cliente {
    protected String cpf;
    protected String nome;
    protected String dataNascimento;
    protected String telefone;

    public Cliente(String cpf, String nome, String dataNascimento, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void exibirInformacoes() {
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Telefone: " + telefone);
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Data de Nascimento: " + dataNascimento + ", Telefone: " + telefone;
    }
}
