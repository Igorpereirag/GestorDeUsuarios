package Entity;

public class Usuario {
    private final String nome;
    private final String email;
    private final String telefone;
    private final String endereco;

    private Usuario(Builder builder) {
        this.nome = builder.nome;
        this.email = builder.email;
        this.telefone = builder.telefone;
        this.endereco = builder.endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }


    public String toString() {

        return "Usuario: " + nome + "\n" + "Email: " + email + "\n" + "Telefone: " + telefone + "\n" + "Endereco: " + endereco;

    }
        

    public static class Builder {
        private final String nome;
        private String email;
        private String telefone;
        private String endereco;

        public Builder(String nome) {
            this.nome = nome;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}
