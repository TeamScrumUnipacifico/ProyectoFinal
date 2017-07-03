package com.reservapp.entrega.presentation.backingBeans;

import com.reservapp.entrega.exceptions.*;
import com.reservapp.entrega.modelo.*;
import com.reservapp.entrega.modelo.dto.FacturaDTO;
import com.reservapp.entrega.presentation.businessDelegate.*;
import com.reservapp.entrega.utilities.*;

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
public class FacturaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(FacturaView.class);
    private InputText txtEstadoPago;
    private InputText txtMetodoPago;
    private InputText txtValorTotal;
    private InputText txtCodigoReserva_Reserva;
    private InputText txtCodigoFactura;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<FacturaDTO> data;
    private FacturaDTO selectedFactura;
    private Factura entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public FacturaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            FacturaDTO facturaDTO = (FacturaDTO) e.getObject();

            if (txtEstadoPago == null) {
                txtEstadoPago = new InputText();
            }

            txtEstadoPago.setValue(facturaDTO.getEstadoPago());

            if (txtMetodoPago == null) {
                txtMetodoPago = new InputText();
            }

            txtMetodoPago.setValue(facturaDTO.getMetodoPago());

            if (txtValorTotal == null) {
                txtValorTotal = new InputText();
            }

            txtValorTotal.setValue(facturaDTO.getValorTotal());

            if (txtCodigoReserva_Reserva == null) {
                txtCodigoReserva_Reserva = new InputText();
            }

            txtCodigoReserva_Reserva.setValue(facturaDTO.getCodigoReserva_Reserva());

            if (txtCodigoFactura == null) {
                txtCodigoFactura = new InputText();
            }

            txtCodigoFactura.setValue(facturaDTO.getCodigoFactura());

            Integer codigoFactura = FacesUtils.checkInteger(txtCodigoFactura);
            entity = businessDelegatorView.getFactura(codigoFactura);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedFactura = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedFactura = null;

        if (txtEstadoPago != null) {
            txtEstadoPago.setValue(null);
            txtEstadoPago.setDisabled(true);
        }

        if (txtMetodoPago != null) {
            txtMetodoPago.setValue(null);
            txtMetodoPago.setDisabled(true);
        }

        if (txtValorTotal != null) {
            txtValorTotal.setValue(null);
            txtValorTotal.setDisabled(true);
        }

        if (txtCodigoReserva_Reserva != null) {
            txtCodigoReserva_Reserva.setValue(null);
            txtCodigoReserva_Reserva.setDisabled(true);
        }

        if (txtCodigoFactura != null) {
            txtCodigoFactura.setValue(null);
            txtCodigoFactura.setDisabled(false);
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
            Integer codigoFactura = FacesUtils.checkInteger(txtCodigoFactura);
            entity = (codigoFactura != null)
                ? businessDelegatorView.getFactura(codigoFactura) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEstadoPago.setDisabled(false);
            txtMetodoPago.setDisabled(false);
            txtValorTotal.setDisabled(false);
            txtCodigoReserva_Reserva.setDisabled(false);
            txtCodigoFactura.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEstadoPago.setValue(entity.getEstadoPago());
            txtEstadoPago.setDisabled(false);
            txtMetodoPago.setValue(entity.getMetodoPago());
            txtMetodoPago.setDisabled(false);
            txtValorTotal.setValue(entity.getValorTotal());
            txtValorTotal.setDisabled(false);
            txtCodigoReserva_Reserva.setValue(entity.getReserva()
                                                    .getCodigoReserva());
            txtCodigoReserva_Reserva.setDisabled(false);
            txtCodigoFactura.setValue(entity.getCodigoFactura());
            txtCodigoFactura.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedFactura = (FacturaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedFactura"));
        txtEstadoPago.setValue(selectedFactura.getEstadoPago());
        txtEstadoPago.setDisabled(false);
        txtMetodoPago.setValue(selectedFactura.getMetodoPago());
        txtMetodoPago.setDisabled(false);
        txtValorTotal.setValue(selectedFactura.getValorTotal());
        txtValorTotal.setDisabled(false);
        txtCodigoReserva_Reserva.setValue(selectedFactura.getCodigoReserva_Reserva());
        txtCodigoReserva_Reserva.setDisabled(false);
        txtCodigoFactura.setValue(selectedFactura.getCodigoFactura());
        txtCodigoFactura.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedFactura == null) && (entity == null)) {
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
            entity = new Factura();

            Integer codigoFactura = FacesUtils.checkInteger(txtCodigoFactura);

            entity.setCodigoFactura(codigoFactura);
            entity.setEstadoPago(FacesUtils.checkString(txtEstadoPago));
            entity.setMetodoPago(FacesUtils.checkString(txtMetodoPago));
            entity.setValorTotal(FacesUtils.checkFloat(txtValorTotal));
            entity.setReserva((FacesUtils.checkInteger(txtCodigoReserva_Reserva) != null)
                ? businessDelegatorView.getReserva(FacesUtils.checkInteger(
                        txtCodigoReserva_Reserva)) : null);
            businessDelegatorView.saveFactura(entity);
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
                Integer codigoFactura = new Integer(selectedFactura.getCodigoFactura());
                entity = businessDelegatorView.getFactura(codigoFactura);
            }

            entity.setEstadoPago(FacesUtils.checkString(txtEstadoPago));
            entity.setMetodoPago(FacesUtils.checkString(txtMetodoPago));
            entity.setValorTotal(FacesUtils.checkFloat(txtValorTotal));
            entity.setReserva((FacesUtils.checkInteger(txtCodigoReserva_Reserva) != null)
                ? businessDelegatorView.getReserva(FacesUtils.checkInteger(
                        txtCodigoReserva_Reserva)) : null);
            businessDelegatorView.updateFactura(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedFactura = (FacturaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedFactura"));

            Integer codigoFactura = new Integer(selectedFactura.getCodigoFactura());
            entity = businessDelegatorView.getFactura(codigoFactura);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer codigoFactura = FacesUtils.checkInteger(txtCodigoFactura);
            entity = businessDelegatorView.getFactura(codigoFactura);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteFactura(entity);
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
            selectedFactura = (FacturaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedFactura"));

            Integer codigoFactura = new Integer(selectedFactura.getCodigoFactura());
            entity = businessDelegatorView.getFactura(codigoFactura);
            businessDelegatorView.deleteFactura(entity);
            data.remove(selectedFactura);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer codigoFactura, String estadoPago,
        String metodoPago, Float valorTotal, Integer codigoReserva_Reserva)
        throws Exception {
        try {
            entity.setEstadoPago(FacesUtils.checkString(estadoPago));
            entity.setMetodoPago(FacesUtils.checkString(metodoPago));
            entity.setValorTotal(FacesUtils.checkFloat(valorTotal));
            businessDelegatorView.updateFactura(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("FacturaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEstadoPago() {
        return txtEstadoPago;
    }

    public void setTxtEstadoPago(InputText txtEstadoPago) {
        this.txtEstadoPago = txtEstadoPago;
    }

    public InputText getTxtMetodoPago() {
        return txtMetodoPago;
    }

    public void setTxtMetodoPago(InputText txtMetodoPago) {
        this.txtMetodoPago = txtMetodoPago;
    }

    public InputText getTxtValorTotal() {
        return txtValorTotal;
    }

    public void setTxtValorTotal(InputText txtValorTotal) {
        this.txtValorTotal = txtValorTotal;
    }

    public InputText getTxtCodigoReserva_Reserva() {
        return txtCodigoReserva_Reserva;
    }

    public void setTxtCodigoReserva_Reserva(InputText txtCodigoReserva_Reserva) {
        this.txtCodigoReserva_Reserva = txtCodigoReserva_Reserva;
    }

    public InputText getTxtCodigoFactura() {
        return txtCodigoFactura;
    }

    public void setTxtCodigoFactura(InputText txtCodigoFactura) {
        this.txtCodigoFactura = txtCodigoFactura;
    }

    public List<FacturaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataFactura();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<FacturaDTO> facturaDTO) {
        this.data = facturaDTO;
    }

    public FacturaDTO getSelectedFactura() {
        return selectedFactura;
    }

    public void setSelectedFactura(FacturaDTO factura) {
        this.selectedFactura = factura;
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
