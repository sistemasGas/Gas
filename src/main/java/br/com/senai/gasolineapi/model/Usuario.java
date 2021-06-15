package br.com.senai.gasolineapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import br.com.senai.gasolineapi.util.PerfilEnum;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private PerfilEnum perfil;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	public String logar(){
        if(login.equals("12312312312") && senha.equals("admin")){
            return "pag-sucesso";
        }
		return login;             
    }
	
	public void validaLogin(Usuario objeto) throws Exception {
        String nome = objeto.getLogin().trim().toLowerCase();
        String invalidos = "1234567890'\"!@#$%¨&*()-_+={[}]/?><;:";
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Nome de usuário inválido!");
            }
        }

        if (objeto.getLogin().equals("")) {
            throw new Exception("Informe a Senha do usuário");
        }
        if (objeto.getSenha().equals("")) {
            throw new Exception("Informe a Senha do usuário");
        }

        //Iterator<AdministradorModel> listaDeUsuario = dal.getAll();
        //for (Iterator<AdministradorModel> it = listaDeUsuario; it.hasNext();) {
        //    AdministradorModel aux = it.next();

          //  if ((objeto.getAdministrador_idem() != aux.getAdministrador_idem()) && (objeto.getLogin().toUpperCase().
            //        equalsIgnoreCase(aux.getAdministrador_nome().toUpperCase()))) {
              //  throw new Exception("O login --> " + objeto.getLogin() + "\nJá existe no cadastro de Usuarios!\n");
            //}
        //}
	}
}