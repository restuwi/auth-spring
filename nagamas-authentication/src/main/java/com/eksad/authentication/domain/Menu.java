package com.eksad.authentication.domain;


import com.eksad.authentication.dto.CreationalSpecificationDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "mst_menu", schema = "public")
public class Menu  {

    @Id
    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "menu_type")
    private String menuType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DataStatus status;

    private CreationalSpecificationDTO menuCreational;

    public Menu() {
    }

    public Menu(String menuId, String menuName, String parentId, String menuType, DataStatus status, CreationalSpecificationDTO menuCreational) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.parentId = parentId;
        this.menuType = menuType;
        this.status = status;
        this.menuCreational = menuCreational;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public DataStatus getStatus() {
        return status;
    }

    public void setStatus(DataStatus status) {
        this.status = status;
    }

    public CreationalSpecificationDTO getMenuCreational() {
        return menuCreational;
    }

    public void setMenuCreational(CreationalSpecificationDTO menuCreational) {
        this.menuCreational = menuCreational;
    }
}
