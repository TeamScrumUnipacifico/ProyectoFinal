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
import com.reservappfinal.entrega.modelo.Menu;
import com.reservappfinal.entrega.modelo.dto.MenuDTO;
import com.reservappfinal.entrega.presentation.businessDelegate.IBusinessDelegatorView;
import com.reservappfinal.entrega.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class MenuView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MenuView.class);
    private InputText txtDescripcion;
    private InputText txtEstado;
    private InputText txtImagen;
    private InputText txtNombre;
    private InputText txtPrecio;
    private InputText txtCodigoEstablecimiento_Establecimiento;
    private InputText txtCodigoMenu;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<MenuDTO> data;
    private MenuDTO selectedMenu;
    private Menu entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public MenuView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            MenuDTO menuDTO = (MenuDTO) e.getObject();

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(menuDTO.getDescripcion());

            if (txtEstado == null) {
                txtEstado = new InputText();
            }

            txtEstado.setValue(menuDTO.getEstado());

            if (txtImagen == null) {
                txtImagen = new InputText();
            }

            txtImagen.setValue(menuDTO.getImagen());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(menuDTO.getNombre());

            if (txtPrecio == null) {
                txtPrecio = new InputText();
            }

            txtPrecio.setValue(menuDTO.getPrecio());

            if (txtCodigoEstablecimiento_Establecimiento == null) {
                txtCodigoEstablecimiento_Establecimiento = new InputText();
            }

            txtCodigoEstablecimiento_Establecimiento.setValue(menuDTO.getCodigoEstablecimiento_Establecimiento());

            if (txtCodigoMenu == null) {
                txtCodigoMenu = new InputText();
            }

            txtCodigoMenu.setValue(menuDTO.getCodigoMenu());

            Integer codigoMenu = FacesUtils.checkInteger(txtCodigoMenu);
            entity = businessDelegatorView.getMenu(codigoMenu);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedMenu = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedMenu = null;

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

        if (txtCodigoEstablecimiento_Establecimiento != null) {
            txtCodigoEstablecimiento_Establecimiento.setValue(null);
            txtCodigoEstablecimiento_Establecimiento.setDisabled(true);
        }

        if (txtCodigoMenu != null) {
            txtCodigoMenu.setValue(null);
            txtCodigoMenu.setDisabled(false);
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
            Integer codigoMenu = FacesUtils.checkInteger(txtCodigoMenu);
            entity = (codigoMenu != null)
                ? businessDelegatorView.getMenu(codigoMenu) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtEstado.setDisabled(false);
            txtImagen.setDisabled(false);
            txtNombre.setDisabled(false);
            txtPrecio.setDisabled(false);
            txtCodigoEstablecimiento_Establecimiento.setDisabled(false);
            txtCodigoMenu.setDisabled(false);
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
            txtCodigoEstablecimiento_Establecimiento.setValue(entity.getEstablecimiento()
                                                                    .getCodigoEstablecimiento());
            txtCodigoEstablecimiento_Establecimiento.setDisabled(false);
            txtCodigoMenu.setValue(entity.getCodigoMenu());
            txtCodigoMenu.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedMenu = (MenuDTO) (evt.getComponent().getAttributes()
                                     .get("selectedMenu"));
        txtDescripcion.setValue(selectedMenu.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtEstado.setValue(selectedMenu.getEstado());
        txtEstado.setDisabled(false);
        txtImagen.setValue(selectedMenu.getImagen());
        txtImagen.setDisabled(false);
        txtNombre.setValue(selectedMenu.getNombre());
        txtNombre.setDisabled(false);
        txtPrecio.setValue(selectedMenu.getPrecio());
        txtPrecio.setDisabled(false);
        txtCodigoEstablecimiento_Establecimiento.setValue(selectedMenu.getCodigoEstablecimiento_Establecimiento());
        txtCodigoEstablecimiento_Establecimiento.setDisabled(false);
        txtCodigoMenu.setValue(selectedMenu.getCodigoMenu());
        txtCodigoMenu.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedMenu == null) && (entity == null)) {
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
            entity = new Menu();

            Integer codigoMenu = FacesUtils.checkInteger(txtCodigoMenu);

            entity.setCodigoMenu(codigoMenu);
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setEstado(FacesUtils.checkInteger(txtEstado));
            entity.setImagen(FacesUtils.checkString(txtImagen));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrecio(FacesUtils.checkInteger(txtPrecio));
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtCodigoEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtCodigoEstablecimiento_Establecimiento)) : null);
            businessDelegatorView.saveMenu(entity);
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
                Integer codigoMenu = new Integer(selectedMenu.getCodigoMenu());
                entity = businessDelegatorView.getMenu(codigoMenu);
            }

            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setEstado(FacesUtils.checkInteger(txtEstado));
            entity.setImagen(FacesUtils.checkString(txtImagen));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrecio(FacesUtils.checkInteger(txtPrecio));
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtCodigoEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtCodigoEstablecimiento_Establecimiento)) : null);
            businessDelegatorView.updateMenu(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedMenu = (MenuDTO) (evt.getComponent().getAttributes()
                                         .get("selectedMenu"));

            Integer codigoMenu = new Integer(selectedMenu.getCodigoMenu());
            entity = businessDelegatorView.getMenu(codigoMenu);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer codigoMenu = FacesUtils.checkInteger(txtCodigoMenu);
            entity = businessDelegatorView.getMenu(codigoMenu);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteMenu(entity);
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
            selectedMenu = (MenuDTO) (evt.getComponent().getAttributes()
                                         .get("selectedMenu"));

            Integer codigoMenu = new Integer(selectedMenu.getCodigoMenu());
            entity = businessDelegatorView.getMenu(codigoMenu);
            businessDelegatorView.deleteMenu(entity);
            data.remove(selectedMenu);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer codigoMenu, String descripcion,
        Integer estado, String imagen, String nombre, Integer precio,
        Integer codigoEstablecimiento_Establecimiento)
        throws Exception {
        try {
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setEstado(FacesUtils.checkInteger(estado));
            entity.setImagen(FacesUtils.checkString(imagen));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setPrecio(FacesUtils.checkInteger(precio));
            businessDelegatorView.updateMenu(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("MenuView").requestRender();
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

    public InputText getTxtCodigoEstablecimiento_Establecimiento() {
        return txtCodigoEstablecimiento_Establecimiento;
    }

    public void setTxtCodigoEstablecimiento_Establecimiento(
        InputText txtCodigoEstablecimiento_Establecimiento) {
        this.txtCodigoEstablecimiento_Establecimiento = txtCodigoEstablecimiento_Establecimiento;
    }

    public InputText getTxtCodigoMenu() {
        return txtCodigoMenu;
    }

    public void setTxtCodigoMenu(InputText txtCodigoMenu) {
        this.txtCodigoMenu = txtCodigoMenu;
    }

    public List<MenuDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<MenuDTO> menuDTO) {
        this.data = menuDTO;
    }

    public MenuDTO getSelectedMenu() {
        return selectedMenu;
    }

    public void setSelectedMenu(MenuDTO menu) {
        this.selectedMenu = menu;
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
