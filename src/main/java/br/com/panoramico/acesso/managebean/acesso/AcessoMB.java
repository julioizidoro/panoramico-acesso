package br.com.panoramico.acesso.managebean.acesso;

import br.com.panoramico.acesso.Dao.AssociadoDao;
import br.com.panoramico.acesso.Dao.ContasReceberDao;
import br.com.panoramico.acesso.Dao.ControleAcessoDao;
import br.com.panoramico.acesso.Dao.DependenteDao;
import br.com.panoramico.acesso.Dao.ExameAssociadoDao;
import br.com.panoramico.acesso.Dao.ExameDao;
import br.com.panoramico.acesso.Dao.ExameDependenteDao;
import br.com.panoramico.acesso.Dao.PassaporteDao;
import br.com.panoramico.acesso.model.Associado;
import br.com.panoramico.acesso.model.Contasreceber;
import br.com.panoramico.acesso.model.Controleacesso;
import br.com.panoramico.acesso.model.Dependente;
import br.com.panoramico.acesso.model.Exame;
import br.com.panoramico.acesso.model.Exameassociado;
import br.com.panoramico.acesso.model.Examedependente;
import br.com.panoramico.acesso.model.Passaporte;
import br.com.panoramico.acesso.util.Formatacao;
import br.com.panoramico.acesso.util.Mensagem;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Named
@ViewScoped
public class AcessoMB implements Serializable {

    @EJB
    private ExameDao exameDao;
    private Exame exame;
    @EJB
    private ContasReceberDao contasReceberDao;
    private Contasreceber contasreceber;
    private String codigoAssociado = "";
    private String codigoDependente = "";
    private String nome;
    private String descricaoNegado;
    private boolean desabilitarLiberado = true;
    private boolean desabilitarNegado = true;
    @EJB
    private AssociadoDao associadoDao;
    private Associado associado;
    @EJB
    private DependenteDao dependenteDao;
    private Dependente dependente;
    @EJB
    private ExameAssociadoDao exameAssociadoDao;
    private Exameassociado exameassociado;
    @EJB
    private ExameDependenteDao exameDependenteDao;
    private Examedependente examedependente;
    private Date dataExame;
    private String corDataExame = "color:black;";
    private String codigoPassaporte = "";
    private boolean habilitarResultado = false;
    private boolean habilitarConsulta = true;
    private String tipoClasse = "";
    private String nomeStatus = "";
    @EJB
    private ControleAcessoDao controleAcessoDao;
    private Controleacesso controleacesso;
    private Passaporte passaporte;
    @EJB
    private PassaporteDao passaporteDao;
    private String guardaAssociado = "";
    private String guardaDependente = "";
    private String guardaPassaporte = "";
    private List<Dependente> listaDependente;
    private boolean habilitarListaDependentes;
    private List<Contasreceber> listaContasReceber;
    private boolean habilitarFinanceiro = false;
    private boolean habilitarBotaoDependente = true;
    private String codigoPesquisa = "";
    private int adultos;
    private int criancas;
    private boolean habilitarInfoPassaporte = false;

    @PostConstruct
    public void init() {
        if (listaDependente == null || listaDependente.isEmpty()) {
            listaDependente = new ArrayList<Dependente>();
        }
    }

    public ExameDao getExameDao() {
        return exameDao;
    }

    public void setExameDao(ExameDao exameDao) {
        this.exameDao = exameDao;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public ContasReceberDao getContasReceberDao() {
        return contasReceberDao;
    }

    public void setContasReceberDao(ContasReceberDao contasReceberDao) {
        this.contasReceberDao = contasReceberDao;
    }

    public Contasreceber getContasreceber() {
        return contasreceber;
    }

    public void setContasreceber(Contasreceber contasreceber) {
        this.contasreceber = contasreceber;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoNegado() {
        return descricaoNegado;
    }

    public void setDescricaoNegado(String descricaoNegado) {
        this.descricaoNegado = descricaoNegado;
    }

    public boolean isDesabilitarLiberado() {
        return desabilitarLiberado;
    }

    public void setDesabilitarLiberado(boolean desabilitarLiberado) {
        this.desabilitarLiberado = desabilitarLiberado;
    }

    public boolean isDesabilitarNegado() {
        return desabilitarNegado;
    }

    public void setDesabilitarNegado(boolean desabilitarNegado) {
        this.desabilitarNegado = desabilitarNegado;
    }

    public AssociadoDao getAssociadoDao() {
        return associadoDao;
    }

    public void setAssociadoDao(AssociadoDao associadoDao) {
        this.associadoDao = associadoDao;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public DependenteDao getDependenteDao() {
        return dependenteDao;
    }

    public void setDependenteDao(DependenteDao dependenteDao) {
        this.dependenteDao = dependenteDao;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public ExameAssociadoDao getExameAssociadoDao() {
        return exameAssociadoDao;
    }

    public void setExameAssociadoDao(ExameAssociadoDao exameAssociadoDao) {
        this.exameAssociadoDao = exameAssociadoDao;
    }

    public Exameassociado getExameassociado() {
        return exameassociado;
    }

    public void setExameassociado(Exameassociado exameassociado) {
        this.exameassociado = exameassociado;
    }

    public ExameDependenteDao getExameDependenteDao() {
        return exameDependenteDao;
    }

    public void setExameDependenteDao(ExameDependenteDao exameDependenteDao) {
        this.exameDependenteDao = exameDependenteDao;
    }

    public Examedependente getExamedependente() {
        return examedependente;
    }

    public void setExamedependente(Examedependente examedependente) {
        this.examedependente = examedependente;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public String getCorDataExame() {
        return corDataExame;
    }

    public void setCorDataExame(String corDataExame) {
        this.corDataExame = corDataExame;
    }

    public boolean isHabilitarResultado() {
        return habilitarResultado;
    }

    public void setHabilitarResultado(boolean habilitarResultado) {
        this.habilitarResultado = habilitarResultado;
    }

    public String getTipoClasse() {
        return tipoClasse;
    }

    public void setTipoClasse(String tipoClasse) {
        this.tipoClasse = tipoClasse;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    public ControleAcessoDao getControleAcessoDao() {
        return controleAcessoDao;
    }

    public void setControleAcessoDao(ControleAcessoDao controleAcessoDao) {
        this.controleAcessoDao = controleAcessoDao;
    }

    public Controleacesso getControleacesso() {
        return controleacesso;
    }

    public void setControleacesso(Controleacesso controleacesso) {
        this.controleacesso = controleacesso;
    }

    public Passaporte getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(Passaporte passaporte) {
        this.passaporte = passaporte;
    }

    public PassaporteDao getPassaporteDao() {
        return passaporteDao;
    }

    public void setPassaporteDao(PassaporteDao passaporteDao) {
        this.passaporteDao = passaporteDao;
    }

    public String getCodigoAssociado() {
        return codigoAssociado;
    }

    public void setCodigoAssociado(String codigoAssociado) {
        this.codigoAssociado = codigoAssociado;
    }

    public String getCodigoDependente() {
        return codigoDependente;
    }

    public void setCodigoDependente(String codigoDependente) {
        this.codigoDependente = codigoDependente;
    }

    public String getCodigoPassaporte() {
        return codigoPassaporte;
    }

    public void setCodigoPassaporte(String codigoPassaporte) {
        this.codigoPassaporte = codigoPassaporte;
    }

    public String getGuardaAssociado() {
        return guardaAssociado;
    }

    public void setGuardaAssociado(String guardaAssociado) {
        this.guardaAssociado = guardaAssociado;
    }

    public String getGuardaDependente() {
        return guardaDependente;
    }

    public void setGuardaDependente(String guardaDependente) {
        this.guardaDependente = guardaDependente;
    }

    public String getGuardaPassaporte() {
        return guardaPassaporte;
    }

    public void setGuardaPassaporte(String guardaPassaporte) {
        this.guardaPassaporte = guardaPassaporte;
    }

    public List<Dependente> getListaDependente() {
        return listaDependente;
    }

    public void setListaDependente(List<Dependente> listaDependente) {
        this.listaDependente = listaDependente;
    }

    public boolean isHabilitarConsulta() {
        return habilitarConsulta;
    }

    public void setHabilitarConsulta(boolean habilitarConsulta) {
        this.habilitarConsulta = habilitarConsulta;
    }

    public boolean isHabilitarListaDependentes() {
        return habilitarListaDependentes;
    }

    public void setHabilitarListaDependentes(boolean habilitarListaDependentes) {
        this.habilitarListaDependentes = habilitarListaDependentes;
    }

    public List<Contasreceber> getListaContasReceber() {
        return listaContasReceber;
    }

    public void setListaContasReceber(List<Contasreceber> listaContasReceber) {
        this.listaContasReceber = listaContasReceber;
    }

    public boolean isHabilitarFinanceiro() {
        return habilitarFinanceiro;
    }

    public void setHabilitarFinanceiro(boolean habilitarFinanceiro) {
        this.habilitarFinanceiro = habilitarFinanceiro;
    }

    public boolean isHabilitarBotaoDependente() {
        return habilitarBotaoDependente;
    }

    public void setHabilitarBotaoDependente(boolean habilitarBotaoDependente) {
        this.habilitarBotaoDependente = habilitarBotaoDependente;
    }

    public String getCodigoPesquisa() {
        return codigoPesquisa;
    }

    public void setCodigoPesquisa(String codigoPesquisa) {
        this.codigoPesquisa = codigoPesquisa;
    }

    public boolean isHabilitarInfoPassaporte() {
        return habilitarInfoPassaporte;
    }

    public void setHabilitarInfoPassaporte(boolean habilitarInfoPassaporte) {
        this.habilitarInfoPassaporte = habilitarInfoPassaporte;
    }

    public int getAdultos() {
        return adultos;
    }

    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }

    public int getCriancas() {
        return criancas;
    }

    public void setCriancas(int criancas) {
        this.criancas = criancas;
    }

    public void pesquisar() {
        boolean habilitarcampo = false;
//        if (guardaAssociado.length() >=1 && codigoAssociado.length() == 0) {
//            codigoAssociado = guardaAssociado;
//        }else if(guardaDependente.length() >= 1 && codigoDependente.length() ==  0){
//            codigoDependente = guardaDependente;
//        }else if(guardaPassaporte.length() >= 1 && codigoPassaporte.length() == 0){
//            codigoPassaporte = guardaPassaporte;
//        }
        if (codigoAssociado.length() >= 1) {
            List<Associado> listaAssociado = associadoDao.list("Select a From Associado a Where a.matricula='" + codigoAssociado + "'");
            for (int i = 0; i < listaAssociado.size(); i++) {
                associado = listaAssociado.get(i);
            }
            if (associado == null) {
                Mensagem.lancarMensagemInfo("Não encontrado", "");
            } else {
                nome = associado.getCliente().getNome();
                exameassociado = null;
                dataExame = null;
                List<Exameassociado> listaExameAssociado = exameAssociadoDao.list("Select ea From Exameassociado ea Where associado.idassociado=" + associado.getIdassociado());
                for (int i = 0; i < listaExameAssociado.size(); i++) {
                    exameassociado = listaExameAssociado.get(i);
                }
                if (exameassociado == null || exameassociado.getIdexameassociado() == null) {
                    Mensagem.lancarMensagemInfo("Não encontrado", "");
                } else {
                    dataExame = exameassociado.getExame().getDatavalidade();
                    if ((dataExame.compareTo(new Date()) == 1)
                            || (dataExame.compareTo(new Date()) == 0)) {
                        if (exameassociado.getAssociado().getSituacao().equalsIgnoreCase("Ativo")) {
                            tipoClasse = "cadastrar";
                            nomeStatus = "LIBERADO";
                            corDataExame = "color:black;";
                            descricaoNegado = "";
                        } else {
                            tipoClasse = "cancelar";
                            nomeStatus = "NEGADO";
                            Mensagem.lancarMensagemInfo("Associado inativo", "");
                            corDataExame = "color:black;";
                        }
                    } else {
                        tipoClasse = "cancelar";
                        nomeStatus = "NEGADO";
                        Mensagem.lancarMensagemInfo("Validade do exame expirada", "");
                        corDataExame = "color:#FB4C4C;";
                    }
                    guardaAssociado = codigoAssociado;
                    habilitarcampo = true;
                    habilitarBotaoDependente = true;
                    listaDependentes();
                    consultaFinanceira();
                }
            }
        } else if (codigoDependente.length() >= 1) {
            List<Dependente> listaDependente = dependenteDao.list("Select d From Dependente d Where d.matricula='" + codigoDependente + "'");
            for (int i = 0; i < listaDependente.size(); i++) {
                dependente = listaDependente.get(i);
            }
            if (dependente == null) {
                Mensagem.lancarMensagemInfo("Não encontrado", "");
            } else {
                nome = dependente.getNome();
                examedependente = null;
                dataExame = null;
                List<Examedependente> listaExameDependente = exameDependenteDao.list("Select ed From Examedependente ed Where dependente.iddependente=" + dependente.getIddependente());
                for (int i = 0; i < listaExameDependente.size(); i++) {
                    examedependente = listaExameDependente.get(i);
                }
                if (examedependente == null || examedependente.getIdexamedependente() == null) {
                    Mensagem.lancarMensagemInfo("Não encontrado", "");
                } else {
                    dataExame = examedependente.getExame().getDatavalidade();
                    if ((dataExame.compareTo(new Date()) == 1)
                            || (dataExame.compareTo(new Date()) == 0)) {
                        if (examedependente.getDependente().getAssociado().getSituacao().equalsIgnoreCase("Ativo")) {
                            tipoClasse = "cadastrar";
                            nomeStatus = "LIBERADO";
                            corDataExame = "color:black;";
                            descricaoNegado = "";
                        }else{
                            tipoClasse = "cancelar";
                            nomeStatus = "NEGADO";
                            Mensagem.lancarMensagemInfo("Associado inativo", "");
                            corDataExame = "color:black;";
                        }
                    } else {
                        tipoClasse = "cancelar";
                        nomeStatus = "NEGADO";
                        Mensagem.lancarMensagemInfo("Validade do exame expirada", "");
                        corDataExame = "color:#FB4C4C;";
                    }
                    guardaDependente = codigoDependente;
                    habilitarBotaoDependente = false;
                    habilitarcampo = true;
                    consultaFinanceira();
                }
            }
        } else if (codigoPassaporte.length() >= 1) {
            List<Passaporte> listaPassaportes = passaporteDao.list("Select p From Passaporte p Where p.localizador='" + codigoPassaporte + "'");
            for (int i = 0; i < listaPassaportes.size(); i++) {
                passaporte = listaPassaportes.get(i);
            }
            if (passaporte == null) {
                Mensagem.lancarMensagemInfo("Não encontrado", "");
            } else {
                nome = passaporte.getCliente().getNome();
                adultos = passaporte.getAdultos();
                criancas = passaporte.getCriancas();
                if (passaporte.getDataacesso() == null) {
                    tipoClasse = "cadastrar";
                    nomeStatus = "LIBERADO";
                    corDataExame = "color:black;";
                    descricaoNegado = "";
                } else {
                    tipoClasse = "cancelar";
                    nomeStatus = "NEGADO";
                    Mensagem.lancarMensagemInfo("Passaporte ja foi utilizado", "");
                    corDataExame = "color:#FB4C4C;";
                }
                guardaPassaporte = codigoPassaporte;
                habilitarBotaoDependente = false;
                habilitarcampo = false;
                habilitarInfoPassaporte = true;
                habilitarConsulta = false;
            }
        }
        if (habilitarcampo) {
            habilitarResultado = true;
            habilitarConsulta = false;
            habilitarListaDependentes = false;
            habilitarFinanceiro = false;
            habilitarInfoPassaporte = false;
        }
    }

    public void controleAcesso() {
        controleacesso = new Controleacesso();
        controleacesso.setSituacao(nomeStatus);
        controleacesso.setData(new Date());
        controleacesso.setHora(retornarHoraAtual());
        if (guardaAssociado.length() >= 1) {
            controleacesso.setIddependente(0);
            controleacesso.setAssociado(associado);
            controleacesso.setTipo("A");
            controleacesso = controleAcessoDao.update(controleacesso);
        } else if (guardaDependente.length() >= 1) {
            controleacesso.setIddependente(dependente.getIddependente());
            controleacesso.setAssociado(dependente.getAssociado());
            controleacesso.setTipo("D");
            controleacesso = controleAcessoDao.update(controleacesso);
        }
        Mensagem.lancarMensagemInfo(controleacesso.getSituacao() + " com sucesso", "");
    }

    public String retornarHoraAtual() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date hora = Calendar.getInstance().getTime();
        return (sdf.format(hora));
    }

    public String novoPassaporte() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("contentWidth", 550);
        RequestContext.getCurrentInstance().openDialog("cadPassaporte", options, null);
        return "";
    }

    public void retornoDialogPassaporte(SelectEvent event) {
        Passaporte passaporte = (Passaporte) event.getObject();
        if (passaporte.getIdpassaporte() != null) {
            Mensagem.lancarMensagemInfo("Compra feita com sucesso", "");
        }
    }

    public String novoRelatorio() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("contentWidth", 580);
        RequestContext.getCurrentInstance().openDialog("imprimirAcesso", options, null);
        return "";
    }

    public void novaPesquisa() {
        habilitarResultado = false;
        habilitarConsulta = true;
        habilitarListaDependentes = false;
        habilitarFinanceiro = false;
        habilitarInfoPassaporte = false;
        listaDependente = new ArrayList<Dependente>();
        codigoAssociado = "";
        codigoDependente = "";
        codigoPassaporte = "";
        guardaAssociado = "";
        guardaDependente = "";
        guardaPassaporte = "";
    }

    public void listaDependentes() {
        listaDependente = dependenteDao.list("Select d From Dependente d Where d.associado.idassociado=" + associado.getIdassociado());
        if (listaDependente == null || listaDependente.isEmpty()) {
            listaDependente = new ArrayList<Dependente>();
        }
        habilitarListaDependentes = true;
        habilitarResultado = false;
        habilitarConsulta = false;
        habilitarFinanceiro = false;
    }

    public void consultaFinanceira() {
        Date dataInicio = treisMesesAtrais();
        Date dataFinal = treisMesesDepois();
        String sql = "";
        if (associado != null) {
            sql = "Select c From Contasreceber c Where c.cliente.idcliente=" + associado.getCliente().getIdcliente();
        } else if (dependente != null) {
            sql = "Select c From Contasreceber c Where c.cliente.idcliente=" + dependente.getAssociado().getCliente().getIdcliente();
        }
        if (sql.length() > 5) {
            sql = sql + " and c.datalancamento>='" + Formatacao.ConvercaoDataSql(dataInicio) + "' and "
                    + " c.datalancamento<='" + Formatacao.ConvercaoDataSql(dataFinal) + "' order by c.datalancamento";
            listaContasReceber = contasReceberDao.list(sql);
        }
        habilitarListaDependentes = false;
        habilitarResultado = false;
        habilitarConsulta = false;
        habilitarFinanceiro = true;
    }

    public Date treisMesesAtrais() {
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date data = c.getTime();
        return data;
    }

    public Date treisMesesDepois() {
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.MONTH, 3);
        Date data = c.getTime();
        return data;
    }

    public void pesquisarDependente() {
        associado = null;
        dependente = null;
        codigoDependente = codigoPesquisa;
        codigoPesquisa = "";
        pesquisar();
    }

    public void pesquisarAssociado() {
        dependente = null;
        associado = null;
        codigoAssociado = codigoPesquisa;
        codigoPesquisa = "";
        pesquisar();
    }

    public void pesquisarPassaporte() {
        codigoPassaporte = codigoPesquisa;
        codigoPesquisa = "";
        pesquisar();
    }

    public String contaVencida(Contasreceber contasreceber) {
        if (contasreceber.getDatalancamento().before(new Date()) && contasreceber.getSituacao().equalsIgnoreCase("PAGAR")) {
            return " color:red;";
        } else {
            return " color:black;";
        }
    }

    public void telaFinanceira() {
        habilitarListaDependentes = false;
        habilitarResultado = false;
        habilitarConsulta = false;
        habilitarFinanceiro = true;
    }

    public void telaDepedente() {
        habilitarListaDependentes = true;
        habilitarResultado = false;
        habilitarConsulta = false;
        habilitarFinanceiro = false;
    }
}
