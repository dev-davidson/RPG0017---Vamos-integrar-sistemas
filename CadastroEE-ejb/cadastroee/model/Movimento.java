package cadastroee.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Movimento")
@NamedQueries({
@NamedQuery(name = "Movimento.findAll", 
        query = "SELECT m FROM Movimento m"),
@NamedQuery(name = "Movimento.findByIdMovimento", 
        query = "SELECT m FROM Movimento m WHERE m.idMovimento = :idMovimento"),
@NamedQuery(name = "Movimento.findByQuantidade", 
        query = "SELECT m FROM Movimento m WHERE m.quantidade = :quantidade"),
@NamedQuery(name = "Movimento.findByTipo", 
        query = "SELECT m FROM Movimento m WHERE m.tipo = :tipo"),
@NamedQuery(name = "Movimento.findByValorUnitario", 
        query = "SELECT m FROM Movimento m WHERE m.valorUnitario = "
                + ":valorUnitario")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimento")
    private Integer idMovimento;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "tipo")
    private Character tipo;
    @Basic(optional = false)
    @Column(name = "valorUnitario")
    private long valorUnitario;
    @JoinColumn(name = "Pessoa_idPessoa", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoaidPessoa;
    @JoinColumn(name = "Produto_idProduto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Produto produtoidProduto;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public Movimento() {
    }

    public Movimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Movimento(Integer idMovimento, int quantidade, Character tipo, 
            long valorUnitario) {
        this.idMovimento = idMovimento;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.valorUnitario = valorUnitario;
    }

    // Getters e Setters
}

