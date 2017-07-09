package com.reservappfinal.entrega.presentation.backingBeans;

import com.reservappfinal.entrega.exceptions.*;
import com.reservappfinal.entrega.modelo.*;
import com.reservappfinal.entrega.modelo.dto.OrdenDTO;
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
public class OrdenView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(OrdenView.class);
    private InputText txtDescripcion;
    private InputText txtEstado;
    private InputText txtImagen;
    private InputText txtNombre;
    private InputText txtPrecio;
    private InputText txtCodigoMenu_Menu;
    private InputText txtCodigoReserva_Reserva;
    private InputText txtCodigoOrden;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<OrdenDTO> data;
    private OrdenDTO selectedOrden;
    private Orden entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public OrdenView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            OrdenDTO ordenDTO = (OrdenDTO) e.getObject();

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(ordenDTO.getDescripcion());

            if (txtEstado == null) {
                txtEstado = new InputText();
            }

            txtEstado.setValue(ordenDTO.getEstado());

            if (txtImagen == null) {
                txtImagen = new InputText();
            }

            txtImagen.setValue(ordenDTO.getImagen());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(ordenDTO.getNombre());

            if (txtPrecio == null) {
                txtPrecio = new InputText();
            }

            txtPrecio.setValue(ordenDTO.getPrecio());

            if (txtCodigoMenu_Menu == null) {
                txtCodigoMenu_Menu = new InputText();
            }

            txtCodigoMenu_Menu.setValue(ordenDTO.getCodigoMenu_Menu());

            if (txtCodigoReserva_Reserva == null) {
                txtCodigoReserva_Reserva = new InputText();
            }

            txtCodigoReserva_Reserva.setValue(ordenDTO.getCodigoReserva_Reserva());

            if (txtCodigoOrden == null) {
                txtCodigoOrden = new InputText();
            }

            txtCodigoOrden.setValue(ordenDTO.getCodigoOrden());

            Integer codigoOrden = FacesUtils.checkInteger(txtCodigoOrden);
            entity = businessDelegatorView.getOrden(codigoOrden);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedOrden = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedOrden = null;

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtEstado != null) {
            txtEstado.setValue(null);
            txtEstado.setDisabled(true);
        }

        if (txtImagen != null) {
            txtImagen.setValue(null);
            txtImagen.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtPrecio != null) {
            txtPrecio.setValue(null);
            txtPrecio.setDisabled(true);
        }

        if (txtCodigoMenu_Menu != null) {
            txtCodigoMenu_Menu.setValue(null);
            txtCodigoMenu_Menu.setDisabled(true);
        }

        if (txtCodigoReserva_Reserva != null) {
            txtCodigoReserva_Reserva.setValue(null);
            txtCodigoReserva_Reserva.setDisabled(true);
        }

        if (txtCodigoOrden != null) {
            txtCodigoOrden.setValue(null);
            txtCodigoOrden.setDisabled(false);
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
            Integer codigoOrden = FacesUtils.checkInteger(txtCodigoOrden);
            entity = (codigoOrden != null)
                ? businessDelegatorView.getOrden(codigoOrden) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtEstado.setDisabled(false);
            txtImagen.setDisabled(false);
            txtNombre.setDisabled(false);
            txtPrecio.setDisabled(false);
            txtCodigoMenu_Menu.setDisabled(false);
            txtCodigoReserva_Reserva.setDisabled(false);
            txtCodigoOrden.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtImagen.setValue(entity.getImagen());
            txtImagen.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtPrecio.setValue(entity.getPrecio());
            txtPrecio.setDisabled(false);
            txtCodigoMenu_Menu.setValue(entity.getMenu().getCodigoMenu());
            txtCodigoMenu_Menu.setDisabled(false);
            txtCodigoReserva_Reserva.setValue(entity.getReserva()
                                                    .getCodigoReserva());
            txtCodigoReserva_Reserva.setDisabled(false);
            txtCodigoOrden.setValue(entity.getCodigoOrden());
            txtCodigoOrden.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedOrden = (OrdenDTO) (evt.getComponent().getAttributes()
                                       .get("selectedOrden"));
        txtDescripcion.setValue(selectedOrden.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtEstado.setValue(selectedOrden.getEstado());
        txtEstado.setDisabled(false);
        txtImagen.setValue(selectedOrden.getImagen());
        txtImagen.setDisabled(false);
        txtNombre.setValue(selectedOrden.getNombre());
        txtNombre.setDisabled(false);
        txtPrecio.setValue(selectedOrden.getPrecio());
        txtPrecio.setDisabled(false);
        txtCodigoMenu_Menu.setValue(selectedOrden.getCodigoMenu_Menu());
        txtCodigoMenu_Menu.setDisabled(false);
        txtCodigoReserva_Reserva.setValue(selectedOrden.getCodigoReserva_Reserva());
        txtCodigoReserva_Reserva.setDisabled(false);
        txtCodigoOrden.setValue(selectedOrden.getCodigoOrden());
        txtCodigoOrden.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedOrden == null) && (entity == null)) {
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
            entity = new Orden();

            Integer codigoOrden = FacesUtils.checkInteger(txtCodigoOrden);

            entity.setCodigoOrden(codigoOrden);
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setEstado(FacesUtils.checkInteger(txtEstado));
            entity.setImagen(FacesUtils.checkString(txtImagen));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrecio(FacesUtils.checkInteger(txtPrecio));
            entity.setMenu((FacesUtils.checkInteger(txtCodigoMenu_Menu) != null)
                ? businessDelegatorView.getMenu(FacesUtils.checkInteger(
                        txtCodigoMenu_Menu)) : null);
            entity.setReserva((FacesUtils.checkInteger(txtCodigoReserva_Reserva) != null)
                ? businessDelegatorView.getReserva(FacesUtils.checkInteger(
                        txtCodigoReserva_Reserva)) : null);
            businessDelegatorView.saveOrden(entity);
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
                Integer codigoOrden = new Integer(selectedOrden.getCodigoOrden());
                entity = businessDelegatorView.getOrden(codigoOrden);
            }

            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setEstado(FacesUtils.checkInteger(txtEstado));
            entity.setImagen(FacesUtils.checkString(txtImagen));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrecio(FacesUtils.checkInteger(txtPrecio));
            entity.setMenu((FacesUtils.checkInteger(txtCodigoMenu_Menu) != null)
                ? businessDelegatorView.getMenu(FacesUtils.checkInteger(
                        txtCodigoMenu_Menu)) : null);
            entity.setReserva((FacesUtils.checkInteger(txtCodigoReserva_Reserva) != null)
                ? businessDelegatorView.getReserva(FacesUtils.checkInteger(
                        txtCodigoReserva_Reserva)) : null);
            businessDelegatorView.updateOrden(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedOrden = (OrdenDTO) (evt.getComponent().getAttributes()
                                           .get("selectedOrden"));

            Integer codigoOrden = new Integer(selectedOrden.getCodigoOrden());
            entity = businessDelegatorView.getOrden(codigoOrden);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer codigoOrden = FacesUtils.checkInteger(txtCodigoOrden);
            entity = businessDelegatorView.getOrden(codigoOrden);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteOrden(entity);
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
            selectedOrden = (OrdenDTO) (evt.getComponent().getAttributes()
                                           .get("selectedOrden"));

            Integer codigoOrden = new Integer(selectedOrden.getCodigoOrden());
            entity = businessDelegatorView.getOrden(codigoOrden);
            businessDelegatorView.deleteOrden(entity);
            data.remove(selectedOrden);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer codigoOrden, String descripcion,
        Integer estado, String imagen, String nombre, Integer precio,
        Integer codigoMenu_Menu, Integer codigoReserva_Reserva)
        throws Exception {
        try {
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setEstado(FacesUtils.checkInteger(estado));
            entity.setImagen(FacesUtils.checkString(imagen));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setPrecio(FacesUtils.checkInteger(precio));
            businessDelegatorView.updateOrden(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("OrdenView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(InputText txtEstado) {
        this.txtEstado = txtEstado;
    }

    public InputText getTxtImagen() {
        return txtImagen;
    }

    public void setTxtImagen(InputText txtImagen) {
        this.txtImagen = txtImagen;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(InputText txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public InputText getTxtCodigoMenu_Menu() {
        return txtCodigoMenu_Menu;
    }

    public void setTxtCodigoMenu_Menu(InputText txtCodigoMenu_Menu) {
        this.txtCodigoMenu_Menu = txtCodigoMenu_Menu;
    }

    public InputText getTxtCodigoReserva_Reserva() {
        return txtCodigoReserva_Reserva;
    }

    public void setTxtCodigoReserva_Reserva(InputText txtCodigoReserva_Reserva) {
        this.txtCodigoReserva_Reserva = txtCodigoReserva_Reserva;
    }

    public InputText getTxtCodigoOrden() {
        return txtCodigoOrden;
    }

    public void setTxtCodigoOrden(InputText txtCodigoOrden) {
        this.txtCodigoOrden = txtCodigoOrden;
    }

    public List<OrdenDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataOrden();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<OrdenDTO> ordenDTO) {
        this.data = ordenDTO;
    }

    public OrdenDTO getSelectedOrden() {
        return selectedOrden;
    }

    public void setSelectedOrden(OrdenDTO orden) {
        this.selectedOrden = orden;
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
