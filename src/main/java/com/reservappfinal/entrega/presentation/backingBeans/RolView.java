package com.reservappfinal.entrega.presentation.backingBeans;

import com.reservappfinal.entrega.exceptions.*;
import com.reservappfinal.entrega.modelo.*;
import com.reservappfinal.entrega.modelo.dto.RolDTO;
import com.reservappfinal.entrega.presentation.businessDelegate.*;
import com.reservappfinal.entrega.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class RolView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RolView.class);
    private InputText txtRolNombre;
    private InputText txtCodigodelRol;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RolDTO> data;
    private RolDTO selectedRol;
    private Rol entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RolView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            RolDTO rolDTO = (RolDTO) e.getObject();

            if (txtRolNombre == null) {
                txtRolNombre = new InputText();
            }

            txtRolNombre.setValue(rolDTO.getRolNombre());

            if (txtCodigodelRol == null) {
                txtCodigodelRol = new InputText();
            }

            txtCodigodelRol.setValue(rolDTO.getCodigodelRol());

            Integer codigodelRol = FacesUtils.checkInteger(txtCodigodelRol);
            entity = businessDelegatorView.getRol(codigodelRol);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedRol = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRol = null;

        if (txtRolNombre != null) {
            txtRolNombre.setValue(null);
            txtRolNombre.setDisabled(true);
        }

        if (txtCodigodelRol != null) {
            txtCodigodelRol.setValue(null);
            txtCodigodelRol.setDisabled(false);
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
            Integer codigodelRol = FacesUtils.checkInteger(txtCodigodelRol);
            entity = (codigodelRol != null)
                ? businessDelegatorView.getRol(codigodelRol) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtRolNombre.setDisabled(false);
            txtCodigodelRol.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtRolNombre.setValue(entity.getRolNombre());
            txtRolNombre.setDisabled(false);
            txtCodigodelRol.setValue(entity.getCodigodelRol());
            txtCodigodelRol.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRol = (RolDTO) (evt.getComponent().getAttributes()
                                   .get("selectedRol"));
        txtRolNombre.setValue(selectedRol.getRolNombre());
        txtRolNombre.setDisabled(false);
        txtCodigodelRol.setValue(selectedRol.getCodigodelRol());
        txtCodigodelRol.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRol == null) && (entity == null)) {
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
            entity = new Rol();

            Integer codigodelRol = FacesUtils.checkInteger(txtCodigodelRol);

            entity.setCodigodelRol(codigodelRol);
            entity.setRolNombre(FacesUtils.checkString(txtRolNombre));
            businessDelegatorView.saveRol(entity);
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
                Integer codigodelRol = new Integer(selectedRol.getCodigodelRol());
                entity = businessDelegatorView.getRol(codigodelRol);
            }

            entity.setRolNombre(FacesUtils.checkString(txtRolNombre));
            businessDelegatorView.updateRol(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRol = (RolDTO) (evt.getComponent().getAttributes()
                                       .get("selectedRol"));

            Integer codigodelRol = new Integer(selectedRol.getCodigodelRol());
            entity = businessDelegatorView.getRol(codigodelRol);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer codigodelRol = FacesUtils.checkInteger(txtCodigodelRol);
            entity = businessDelegatorView.getRol(codigodelRol);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRol(entity);
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
            selectedRol = (RolDTO) (evt.getComponent().getAttributes()
                                       .get("selectedRol"));

            Integer codigodelRol = new Integer(selectedRol.getCodigodelRol());
            entity = businessDelegatorView.getRol(codigodelRol);
            businessDelegatorView.deleteRol(entity);
            data.remove(selectedRol);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer codigodelRol, String rolNombre)
        throws Exception {
        try {
            entity.setRolNombre(FacesUtils.checkString(rolNombre));
            businessDelegatorView.updateRol(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RolView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtRolNombre() {
        return txtRolNombre;
    }

    public void setTxtRolNombre(InputText txtRolNombre) {
        this.txtRolNombre = txtRolNombre;
    }

    public InputText getTxtCodigodelRol() {
        return txtCodigodelRol;
    }

    public void setTxtCodigodelRol(InputText txtCodigodelRol) {
        this.txtCodigodelRol = txtCodigodelRol;
    }

    public List<RolDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRol();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RolDTO> rolDTO) {
        this.data = rolDTO;
    }

    public RolDTO getSelectedRol() {
        return selectedRol;
    }

    public void setSelectedRol(RolDTO rol) {
        this.selectedRol = rol;
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
