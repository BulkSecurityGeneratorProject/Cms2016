package com.application.cms.service.mapper;

import com.application.cms.domain.*;
import com.application.cms.service.dto.MenuDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Menu and its DTO MenuDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MenuMapper {

    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "menu.id", target = "menuId")
    MenuDTO menuToMenuDTO(Menu menu);

    List<MenuDTO> menusToMenuDTOs(List<Menu> menus);

    @Mapping(source = "typeId", target = "type")
    @Mapping(source = "menuId", target = "menu")
    @Mapping(target = "submenus", ignore = true)
    Menu menuDTOToMenu(MenuDTO menuDTO);

    List<Menu> menuDTOsToMenus(List<MenuDTO> menuDTOs);

    default MenuType menuTypeFromId(Long id) {
        if (id == null) {
            return null;
        }
        MenuType menuType = new MenuType();
        menuType.setId(id);
        return menuType;
    }

    default Menu menuFromId(Long id) {
        if (id == null) {
            return null;
        }
        Menu menu = new Menu();
        menu.setId(id);
        return menu;
    }
}
