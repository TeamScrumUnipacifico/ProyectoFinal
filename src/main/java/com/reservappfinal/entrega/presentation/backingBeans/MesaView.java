package com.reservappfinal.entrega.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reservappfinal.entrega.exceptions.ZMessManager;
import com.reservappfinal.entrega.modelo.Mesa;
import com.reservappfinal.entrega.modelo.dto.MesaDTO;
import com.reservappfinal.entrega.presentation.businessDelegate.IBusinessDelegatorView;
import com.reservappfinal.entrega.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class MesaView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MesaView.class);
    private InputText txtEstado;
    private InputText txtPuestos;
    private InputText txtUbicacion;
    private InputText txtCodigoEstablecimiento_Establecimiento;
    private InputText txtCodigoMesa;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<MesaDTO> data;
    private MesaDTO selectedMesa;
    private Mesa entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public MesaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            MesaDTO mesaDTO = (MesaDTO) e.getObject();

            if (txtEstado == null) {
                txtEstado = new InputText();
            }

            txtEstado.setValue(mesaDTO.getEstado());

            if (txtPuestos == null) {
                txtPuestos = new InputText();
            }

            txtPuestos.setValue(mesaDTO.getPuestos());

            if (txtUbicacion == null) {
                txtUbicacion = new InputText();
            }

            txtUbicacion.setValue(mesaDTO.getUbicacion());

            if (txtCodigoEstablecimiento_Establecimiento == null) {
                txtCodigoEstablecimiento_Establecimiento = new InputText();
            }

            txtCodigoEstablecimiento_Establecimiento.setValue(mesaDTO.getCodigoEstablecimiento_Establecimiento());

            if (txtCodigoMesa == null) {
                txtCodigoMesa = new InputText();
            }

            txtCodigoMesa.setValue(mesaDTO.getCodigoMesa());

            Integer codigoMesa = FacesUtils.checkInteger(txtCodigoMesa);
            entity = businessDelegatorView.getMesa(codigoMesa);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedMesa = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedMesa = null;

        if (txtEstado != null) {
            txtEstado.setValue(null);
            txtEstado.setDisabled(true);
        }

        if (txtPuestos != null) {
            txtPuestos.setValue(null);
            txtPuestos.setDisabled(true);
        }

        if (txtUbicacion != null) {
            txtUbicacion.setValue(null);
            txtUbicacion.setDisabled(true);
        }

        if (txtCodigoEstablecimiento_Establecimiento != null) {
            txtCodigoEstablecimiento_Establecimiento.setValue(null);
            txtCodigoEstablecimiento_Establecimiento.setDisabled(true);
        }

        if (txtCodigoMesa != null) {
            txtCodigoMesa.setValue(null);
            txtCodigoMesa.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer codigoMesa = FacesUtils.checkInteger(txtCodigoMesa);
            entity = (codigoMesa != null)
                ? businessDelegatorView.getMesa(codigoMesa) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEstado.setDisabled(false);
            txtPuestos.setDisabled(false);
            txtUbicacion.setDisabled(false);
            txtCodigoEstablecimiento_Establecimiento.setDisabled(false);
            txtCodigoMesa.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtPuestos.setValue(entity.getPuestos());
            txtPuestos.setDisabled(false);
            txtUbicacion.setValue(entity.getUbicacion());
            txtUbicacion.setDisabled(false);
            txtCodigoEstablecimiento_Establecimiento.setValue(entity.getEstablecimiento()
                                                                    .getCodigoEstablecimiento());
            txtCodigoEstablecimiento_Establecimiento.setDisabled(false);
            txtCodigoMesa.setValue(entity.getCodigoMesa());
            txtCodigoMesa.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedMesa = (MesaDTO) (evt.getComponent().getAttributes()
                                     .get("selectedMesa"));
        txtEstado.setValue(selectedMesa.getEstado());
        txtEstado.setDisabled(false);
        txtPuestos.setValue(selectedMesa.getPuestos());
        txtPuestos.setDisabled(false);
        txtUbicacion.setValue(selectedMesa.getUbicacion());
        txtUbicacion.setDisabled(false);
        txtCodigoEstablecimiento_Establecimiento.setValue(selectedMesa.getCodigoEstablecimiento_Establecimiento());
        txtCodigoEstablecimiento_Establecimiento.setDisabled(false);
        txtCodigoMesa.setValue(selectedMesa.getCodigoMesa());
        txtCodigoMesa.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedMesa == null) && (entity == null)) {
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
            entity = new Mesa();

            Integer codigoMesa = FacesUtils.checkInteger(txtCodigoMesa);

            entity.setCodigoMesa(codigoMesa);
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setPuestos(FacesUtils.checkInteger(txtPuestos));
            entity.setUbicacion(FacesUtils.checkString(txtUbicacion));
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtCodigoEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtCodigoEstablecimiento_Establecimiento)) : null);
            businessDelegatorView.saveMesa(entity);
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
                Integer codigoMesa = new Integer(selectedMesa.getCodigoMesa());
                entity = businessDelegatorView.getMesa(codigoMesa);
            }

            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setPuestos(FacesUtils.checkInteger(txtPuestos));
            entity.setUbicacion(FacesUtils.checkString(txtUbicacion));
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtCodigoEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtCodigoEstablecimiento_Establecimiento)) : null);
            businessDelegatorView.updateMesa(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedMesa = (MesaDTO) (evt.getComponent().getAttributes()
                                         .get("selectedMesa"));

            Integer codigoMesa = new Integer(selectedMesa.getCodigoMesa());
            entity = businessDelegatorView.getMesa(codigoMesa);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer codigoMesa = FacesUtils.checkInteger(txtCodigoMesa);
            entity = businessDelegatorView.getMesa(codigoMesa);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteMesa(entity);
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
            selectedMesa = (MesaDTO) (evt.getComponent().getAttributes()
                                         .get("selectedMesa"));

            Integer codigoMesa = new Integer(selectedMesa.getCodigoMesa());
            entity = businessDelegatorView.getMesa(codigoMesa);
            businessDelegatorView.deleteMesa(entity);
            data.remove(selectedMesa);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer codigoMesa, String estado,
        Integer puestos, String ubicacion,
        Integer codigoEstablecimiento_Establecimiento)
        throws Exception {
        try {
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setPuestos(FacesUtils.checkInteger(puestos));
            entity.setUbicacion(FacesUtils.checkString(ubicacion));
            businessDelegatorView.updateMesa(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("MesaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(InputText txtEstado) {
        this.txtEstado = txtEstado;
    }

    public InputText getTxtPuestos() {
        return txtPuestos;
    }

    public void setTxtPuestos(InputText txtPuestos) {
        this.txtPuestos = txtPuestos;
    }

    public InputText getTxtUbicacion() {
        return txtUbicacion;
    }

    public void setTxtUbicacion(InputText txtUbicacion) {
        this.txtUbicacion = txtUbicacion;
    }

    public InputText getTxtCodigoEstablecimiento_Establecimiento() {
        return txtCodigoEstablecimiento_Establecimiento;
    }

    public void setTxtCodigoEstablecimiento_Establecimiento(
        InputText txtCodigoEstablecimiento_Establecimiento) {
        this.txtCodigoEstablecimiento_Establecimiento = txtCodigoEstablecimiento_Establecimiento;
    }

    public InputText getTxtCodigoMesa() {
        return txtCodigoMesa;
    }

    public void setTxtCodigoMesa(InputText txtCodigoMesa) {
        this.txtCodigoMesa = txtCodigoMesa;
    }

    public List<MesaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataMesa();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<MesaDTO> mesaDTO) {
        this.data = mesaDTO;
    }

    public MesaDTO getSelectedMesa() {
        return selectedMesa;
    }

    public void setSelectedMesa(MesaDTO mesa) {
        this.selectedMesa = mesa;
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
