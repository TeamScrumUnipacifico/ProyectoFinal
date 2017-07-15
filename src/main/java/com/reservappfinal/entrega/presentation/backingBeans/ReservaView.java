package com.reservappfinal.entrega.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reservappfinal.entrega.exceptions.ZMessManager;
import com.reservappfinal.entrega.modelo.Reserva;
import com.reservappfinal.entrega.modelo.dto.ReservaDTO;
import com.reservappfinal.entrega.presentation.businessDelegate.IBusinessDelegatorView;
import com.reservappfinal.entrega.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ReservaView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ReservaView.class);
    private InputText txtIdMesa;
    private InputText txtUsuarioIdUsuario;
    private InputText txtCodigoMesa_Mesa;
    private InputText txtDocumento_Usuario;
    private InputText txtCodigoReserva;
    private Calendar txtFechaReserva;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ReservaDTO> data;
    private ReservaDTO selectedReserva;
    private Reserva entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ReservaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ReservaDTO reservaDTO = (ReservaDTO) e.getObject();

            if (txtIdMesa == null) {
                txtIdMesa = new InputText();
            }

            txtIdMesa.setValue(reservaDTO.getIdMesa());

            if (txtUsuarioIdUsuario == null) {
                txtUsuarioIdUsuario = new InputText();
            }

            txtUsuarioIdUsuario.setValue(reservaDTO.getUsuarioIdUsuario());

            if (txtCodigoMesa_Mesa == null) {
                txtCodigoMesa_Mesa = new InputText();
            }

            txtCodigoMesa_Mesa.setValue(reservaDTO.getCodigoMesa_Mesa());

            if (txtDocumento_Usuario == null) {
                txtDocumento_Usuario = new InputText();
            }

            txtDocumento_Usuario.setValue(reservaDTO.getDocumento_Usuario());

            if (txtCodigoReserva == null) {
                txtCodigoReserva = new InputText();
            }

            txtCodigoReserva.setValue(reservaDTO.getCodigoReserva());

            if (txtFechaReserva == null) {
                txtFechaReserva = new Calendar();
            }

            txtFechaReserva.setValue(reservaDTO.getFechaReserva());

            Integer codigoReserva = FacesUtils.checkInteger(txtCodigoReserva);
            entity = businessDelegatorView.getReserva(codigoReserva);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedReserva = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedReserva = null;

        if (txtIdMesa != null) {
            txtIdMesa.setValue(null);
            txtIdMesa.setDisabled(true);
        }

        if (txtUsuarioIdUsuario != null) {
            txtUsuarioIdUsuario.setValue(null);
            txtUsuarioIdUsuario.setDisabled(true);
        }

        if (txtCodigoMesa_Mesa != null) {
            txtCodigoMesa_Mesa.setValue(null);
            txtCodigoMesa_Mesa.setDisabled(true);
        }

        if (txtDocumento_Usuario != null) {
            txtDocumento_Usuario.setValue(null);
            txtDocumento_Usuario.setDisabled(true);
        }

        if (txtFechaReserva != null) {
            txtFechaReserva.setValue(null);
            txtFechaReserva.setDisabled(true);
        }

        if (txtCodigoReserva != null) {
            txtCodigoReserva.setValue(null);
            txtCodigoReserva.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFechaReserva() {
        Date inputDate = (Date) txtFechaReserva.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer codigoReserva = FacesUtils.checkInteger(txtCodigoReserva);
            entity = (codigoReserva != null)
                ? businessDelegatorView.getReserva(codigoReserva) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdMesa.setDisabled(false);
            txtUsuarioIdUsuario.setDisabled(false);
            txtCodigoMesa_Mesa.setDisabled(false);
            txtDocumento_Usuario.setDisabled(false);
            txtFechaReserva.setDisabled(false);
            txtCodigoReserva.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechaReserva.setValue(entity.getFechaReserva());
            txtFechaReserva.setDisabled(false);
            txtIdMesa.setValue(entity.getIdMesa());
            txtIdMesa.setDisabled(false);
            txtUsuarioIdUsuario.setValue(entity.getUsuarioIdUsuario());
            txtUsuarioIdUsuario.setDisabled(false);
            txtCodigoMesa_Mesa.setValue(entity.getMesa().getCodigoMesa());
            txtCodigoMesa_Mesa.setDisabled(false);
            txtDocumento_Usuario.setValue(entity.getUsuario().getDocumento());
            txtDocumento_Usuario.setDisabled(false);
            txtCodigoReserva.setValue(entity.getCodigoReserva());
            txtCodigoReserva.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedReserva = (ReservaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedReserva"));
        txtFechaReserva.setValue(selectedReserva.getFechaReserva());
        txtFechaReserva.setDisabled(false);
        txtIdMesa.setValue(selectedReserva.getIdMesa());
        txtIdMesa.setDisabled(false);
        txtUsuarioIdUsuario.setValue(selectedReserva.getUsuarioIdUsuario());
        txtUsuarioIdUsuario.setDisabled(false);
        txtCodigoMesa_Mesa.setValue(selectedReserva.getCodigoMesa_Mesa());
        txtCodigoMesa_Mesa.setDisabled(false);
        txtDocumento_Usuario.setValue(selectedReserva.getDocumento_Usuario());
        txtDocumento_Usuario.setDisabled(false);
        txtCodigoReserva.setValue(selectedReserva.getCodigoReserva());
        txtCodigoReserva.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedReserva == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Reserva();

            Integer codigoReserva = FacesUtils.checkInteger(txtCodigoReserva);

            entity.setCodigoReserva(codigoReserva);
            entity.setFechaReserva(FacesUtils.checkDate(txtFechaReserva));
            entity.setIdMesa(FacesUtils.checkInteger(txtIdMesa));
            entity.setUsuarioIdUsuario(FacesUtils.checkInteger(
                    txtUsuarioIdUsuario));
            entity.setMesa((FacesUtils.checkInteger(txtCodigoMesa_Mesa) != null)
                ? businessDelegatorView.getMesa(FacesUtils.checkInteger(
                        txtCodigoMesa_Mesa)) : null);
            entity.setUsuario((FacesUtils.checkString(txtDocumento_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkString(
                        txtDocumento_Usuario)) : null);
            businessDelegatorView.saveReserva(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer codigoReserva = new Integer(selectedReserva.getCodigoReserva());
                entity = businessDelegatorView.getReserva(codigoReserva);
            }

            entity.setFechaReserva(FacesUtils.checkDate(txtFechaReserva));
            entity.setIdMesa(FacesUtils.checkInteger(txtIdMesa));
            entity.setUsuarioIdUsuario(FacesUtils.checkInteger(
                    txtUsuarioIdUsuario));
            entity.setMesa((FacesUtils.checkInteger(txtCodigoMesa_Mesa) != null)
                ? businessDelegatorView.getMesa(FacesUtils.checkInteger(
                        txtCodigoMesa_Mesa)) : null);
            entity.setUsuario((FacesUtils.checkString(txtDocumento_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkString(
                        txtDocumento_Usuario)) : null);
            businessDelegatorView.updateReserva(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedReserva = (ReservaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedReserva"));

            Integer codigoReserva = new Integer(selectedReserva.getCodigoReserva());
            entity = businessDelegatorView.getReserva(codigoReserva);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer codigoReserva = FacesUtils.checkInteger(txtCodigoReserva);
            entity = businessDelegatorView.getReserva(codigoReserva);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteReserva(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedReserva = (ReservaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedReserva"));

            Integer codigoReserva = new Integer(selectedReserva.getCodigoReserva());
            entity = businessDelegatorView.getReserva(codigoReserva);
            businessDelegatorView.deleteReserva(entity);
            data.remove(selectedReserva);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer codigoReserva, Date fechaReserva,
        Integer idMesa, Integer usuarioIdUsuario, Integer codigoMesa_Mesa,
        String documento_Usuario) throws Exception {
        try {
            entity.setFechaReserva(FacesUtils.checkDate(fechaReserva));
            entity.setIdMesa(FacesUtils.checkInteger(idMesa));
            entity.setUsuarioIdUsuario(FacesUtils.checkInteger(usuarioIdUsuario));
            businessDelegatorView.updateReserva(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ReservaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdMesa() {
        return txtIdMesa;
    }

    public void setTxtIdMesa(InputText txtIdMesa) {
        this.txtIdMesa = txtIdMesa;
    }

    public InputText getTxtUsuarioIdUsuario() {
        return txtUsuarioIdUsuario;
    }

    public void setTxtUsuarioIdUsuario(InputText txtUsuarioIdUsuario) {
        this.txtUsuarioIdUsuario = txtUsuarioIdUsuario;
    }

    public InputText getTxtCodigoMesa_Mesa() {
        return txtCodigoMesa_Mesa;
    }

    public void setTxtCodigoMesa_Mesa(InputText txtCodigoMesa_Mesa) {
        this.txtCodigoMesa_Mesa = txtCodigoMesa_Mesa;
    }

    public InputText getTxtDocumento_Usuario() {
        return txtDocumento_Usuario;
    }

    public void setTxtDocumento_Usuario(InputText txtDocumento_Usuario) {
        this.txtDocumento_Usuario = txtDocumento_Usuario;
    }

    public Calendar getTxtFechaReserva() {
        return txtFechaReserva;
    }

    public void setTxtFechaReserva(Calendar txtFechaReserva) {
        this.txtFechaReserva = txtFechaReserva;
    }

    public InputText getTxtCodigoReserva() {
        return txtCodigoReserva;
    }

    public void setTxtCodigoReserva(InputText txtCodigoReserva) {
        this.txtCodigoReserva = txtCodigoReserva;
    }

    public List<ReservaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataReserva();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ReservaDTO> reservaDTO) {
        this.data = reservaDTO;
    }

    public ReservaDTO getSelectedReserva() {
        return selectedReserva;
    }

    public void setSelectedReserva(ReservaDTO reserva) {
        this.selectedReserva = reserva;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
