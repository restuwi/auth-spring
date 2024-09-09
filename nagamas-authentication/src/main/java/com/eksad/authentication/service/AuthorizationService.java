package com.eksad.authentication.service;

import com.eksad.authentication.common.*;
import com.eksad.authentication.dto.*;
import com.eksad.authentication.repository.*;
import com.eksad.authentication.domain.*;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AuthorizationService {

    private final VwMasterAccessMenuRepository vwMasterAccessMenuRepository;
    private final VwMasterAccesFormRepository vwMasterAccesFormRepository;
    private final VwMasterAccessRoleRepository vwMasterAccessRoleRepository;

    private static final Logger log = LoggerFactory.getLogger(AuthorizationService.class);


    public AuthorizationService(VwMasterAccessMenuRepository vwMasterAccessMenuRepository, VwMasterAccesFormRepository vwMasterAccesFormRepository, VwMasterAccessRoleRepository vwMasterAccessRoleRepository) {
        this.vwMasterAccessMenuRepository = vwMasterAccessMenuRepository;
        this.vwMasterAccesFormRepository = vwMasterAccesFormRepository;
        this.vwMasterAccessRoleRepository = vwMasterAccessRoleRepository;
    }

    public GenericResponseDTO<List<MenuAccessResponseDto>> getMenuAccessService(Long userId, String name) {
        List<MenuAccessResponseDto> menuAccessListRestu = new ArrayList<>();

        MenuAccessResponseDto menuAccessMaster = new MenuAccessResponseDto();
        menuAccessMaster.setEmpId("E001");
        menuAccessMaster.setMenuId("MASTER");
        menuAccessMaster.setDescription("Master Description");
        menuAccessMaster.setUserId(String.valueOf(userId));
        menuAccessListRestu.add(menuAccessMaster);


        MenuAccessResponseDto menuAccessH1Module = new MenuAccessResponseDto();
        menuAccessH1Module.setEmpId("E001");
        menuAccessH1Module.setMenuId("H1MODULE");
        menuAccessH1Module.setDescription("H1 Description");
        menuAccessH1Module.setUserId(String.valueOf(userId));
        menuAccessListRestu.add(menuAccessH1Module);

        MenuAccessResponseDto menuAccessH23Module = new MenuAccessResponseDto();
        menuAccessH23Module.setEmpId("E001");
        menuAccessH23Module.setMenuId("H23MODULE");
        menuAccessH23Module.setDescription("H23 Description");
        menuAccessH23Module.setUserId(String.valueOf(userId));
        menuAccessListRestu.add(menuAccessH23Module);

        List<ListFormItem> formItemListMaster = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            ListFormItem formItem = new ListFormItem();
            String formId = String.format("MASTER-%03d", i);
            formItem.setFormId(formId);
            formItem.setEmplId("E001");
            formItem.setMenuId("MASTER");
            formItem.setDescription("Form Description " + i);
            formItem.setUserId(String.valueOf(userId));
            formItemListMaster.add(formItem);
        }
        menuAccessMaster.setListForm(formItemListMaster);

        List<ListFormItem> formItemListH1Module = new ArrayList<>();
        for (int i = 1 ; i <= 16;i++ ){
            ListFormItem formItem = new ListFormItem();
            String formId = String.format("H1MODULE-%03d", i);
            formItem.setFormId(formId);
            formItem.setEmplId("E001");
            formItem.setMenuId("H1MODULE");
            formItem.setDescription("Form Description " + i);
            formItem.setUserId(String.valueOf(userId));
            formItemListH1Module.add(formItem);
        }
        menuAccessH1Module.setListForm(formItemListH1Module);


        List<ListFormItem> formItemListH23Module = new ArrayList<>();
        for (int i = 1 ; i <= 14;i++ ){
            ListFormItem formItem = new ListFormItem();
            String formId = String.format("H23MODULE-%03d", i);
            formItem.setFormId(formId);
            formItem.setEmplId("E001");
            formItem.setMenuId("H23MODULE");
            formItem.setDescription("Form Description " + i);
            formItem.setUserId(String.valueOf(userId));
            formItemListH23Module.add(formItem);
        }
        menuAccessH23Module.setListForm(formItemListH23Module);


        ///dummy data dea
        List<MenuAccessResponseDto> menuAccessListDea = new ArrayList<>();
//        MenuAccessResponseDto menuAccessMasterDea = new MenuAccessResponseDto();
//        menuAccessMasterDea.setMenuId("MASTER");
//        menuAccessMasterDea.setUserId(String.valueOf(userId));
//        menuAccessMasterDea.setEmpId("E002");
//        menuAccessListDea.add(menuAccessMasterDea);

        MenuAccessResponseDto menuAccessH1ModuleDea = new MenuAccessResponseDto();
        menuAccessH1ModuleDea.setMenuId("H1MODULE");
        menuAccessH1ModuleDea.setUserId(String.valueOf(userId));
        menuAccessH1ModuleDea.setEmpId("E002");
        menuAccessH1ModuleDea.setDescription("Menu H1MODULE");
        menuAccessListDea.add(menuAccessH1ModuleDea);

        MenuAccessResponseDto menuAccessH23ModuleDea = new MenuAccessResponseDto();
        menuAccessH23ModuleDea.setMenuId("H23MODULE");
        menuAccessH23ModuleDea.setUserId(String.valueOf(userId));
        menuAccessH23ModuleDea.setEmpId("E002");
        menuAccessH23ModuleDea.setDescription("Menu H23Module");
        menuAccessListDea.add(menuAccessH23ModuleDea);

//        List<ListFormItem> formItemListMasterDea = new ArrayList<>();
//        for (int i = 1; i <= 25; i++) {
//            ListFormItem formItem = new ListFormItem();
//            String formId = String.format("MASTER-%03d", i);
//            formItem.setFormId(formId);
//            formItem.setEmplId("E001");
//            formItem.setMenuId("MASTER");
//            formItem.setDescription("Form Description " + i);
//            formItem.setId("ID" + String.format("%03d", i));
//            formItem.setUserId(String.valueOf(userId));
//            formItemListMasterDea.add(formItem);
//        }
//        menuAccessMasterDea.setListForm(formItemListMasterDea);

        List<ListFormItem> formItemListH1ModuleDea = new ArrayList<>();
        for (int i = 1 ; i <= 8;i++ ){
            ListFormItem formItem = new ListFormItem();
            String formId = String.format("H1MODULE-%03d", i);
            formItem.setFormId(formId);
            formItem.setEmplId("E001");
            formItem.setMenuId("H1MODULE");
            formItem.setDescription("Form Description " + i);
            formItem.setUserId(String.valueOf(userId));
            formItemListH1ModuleDea.add(formItem);
        }
        menuAccessH1ModuleDea.setListForm(formItemListH1ModuleDea);


        List<ListFormItem> formItemListH23ModuleDea = new ArrayList<>();
        for (int i = 1 ; i <= 10;i++ ){
            ListFormItem formItem = new ListFormItem();
            String formId = String.format("H23MODULE-%03d", i);
            formItem.setFormId(formId);
            formItem.setEmplId("E001");
            formItem.setMenuId("H23MODULE");
            formItem.setDescription("Form Description " + i);
            formItem.setUserId(String.valueOf(userId));
            formItemListH23ModuleDea.add(formItem);
        }
        menuAccessH23ModuleDea.setListForm(formItemListH23ModuleDea);

        GenericResponseDTO<List<MenuAccessResponseDto>> response = new GenericResponseDTO<>();
        response.setStatus(ResponseStatus.S);
        response.setCode(200);
        if (name.equals("Restu")){
            response.setData(menuAccessListRestu);
        } else {
            response.setData(menuAccessListDea);
        }

        return response;
    }

    public GenericResponseDTO<List<MenuAccessResponseDto>> getMenuAccessServiceV2(Long userId){
        GenericResponseDTO<List<MenuAccessResponseDto>> response = new GenericResponseDTO<>();
        List<MenuAccessResponseDto> menuAccessResponseList = new ArrayList<>();

        List<ViewMasterAccessMenu> listMenu = vwMasterAccessMenuRepository.findAllByUserId(String.valueOf(userId));
        List<ViewMasterAccessForm> listForm = vwMasterAccesFormRepository.findAllByUserId(String.valueOf(userId));

        listMenu.forEach(menu -> {
            MenuAccessResponseDto menuAccess = new MenuAccessResponseDto();
            menuAccess.setEmpId(menu.getEmplId());
            menuAccess.setMenuId(menu.getMenuId());
            menuAccess.setDescription(menu.getDescription());
            menuAccess.setUserId(menu.getUserId());

            List<ListFormItem> formItems = listForm.stream()
                    .filter(form -> form.getMenuId().equals(menu.getMenuId()) && form.getUserId().equals(String.valueOf(userId)))
                    .map(form -> {
                        ListFormItem formItem = new ListFormItem();
                        formItem.setFormId(form.getFormId());
                        formItem.setEmplId(form.getEmplId());
                        formItem.setMenuId(menu.getMenuId());
                        formItem.setDescription(form.getDescription());
                        formItem.setUserId(form.getUserId());
                        formItem.setReadAccess(form.getReadAccess());
                        formItem.setWriteAccess(form.getWriteAccess());
                        formItem.setEditAccess(form.getEditAccess());
                        formItem.setDeleteAccess(form.getDeleteAccess());
                        return formItem;
                    })
                    .collect(Collectors.toList());

            menuAccess.setListForm(formItems);
            menuAccessResponseList.add(menuAccess);
        });

        response.setData(menuAccessResponseList);
        response.setStatus(ResponseStatus.S);
        response.setCode(200);

        return response;
    }

    public GenericResponseDTO<ListFormItem> getAccessFormItem(String userId, RequestFormItemDto request){
        GenericResponseDTO<ListFormItem> finalResponse = new GenericResponseDTO<>();
        ListFormItem response = new ListFormItem();
        if(StringUtil.isNullOrEmpty(request.getFormId())){
            finalResponse.setStatus(ResponseStatus.F);
            finalResponse.setMessage("form id must be filled in");
            finalResponse.setCode(400);
            finalResponse.setData(response);
            return finalResponse;
        }

        String formId = request.getFormId();
        try {
            Optional<ViewMasterAccessForm> formItem = vwMasterAccesFormRepository.findByUserIdAndFormId(userId, formId);
            if(formItem.isPresent()) {
                ViewMasterAccessForm form = formItem.get();
                response.setUserId(form.getUserId());
                response.setEmplId(form.getEmplId());
                response.setMenuId(form.getMenuId());
                response.setFormId(form.getFormId());
                response.setDescription(form.getDescription());
                response.setWriteAccess(form.getWriteAccess());
                response.setReadAccess(form.getReadAccess());
                response.setEditAccess(form.getReadAccess());
                response.setDeleteAccess(form.getDeleteAccess());
                finalResponse.setStatus(ResponseStatus.S);
                finalResponse.setMessage("Process Successed");
                finalResponse.setCode(200);
                finalResponse.setData(response);
                return finalResponse;
            } else {
                finalResponse.setStatus(ResponseStatus.F);
                finalResponse.setMessage("form not found");
                finalResponse.setData(response);
                return finalResponse;
            }

        } catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
            log.info(String.valueOf(JsonObject.mapFrom(
                    LogOpsUtil.getErrorResponse(ProjectType.CRUD, "Security", new Date(), "Rest",
                            String.valueOf(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()), e.getStackTrace()))));
            return new GenericResponseDTO().errorResponse(HttpResponseStatus.NOT_FOUND.code(), e.getLocalizedMessage());
        }
    }

//    public GenericResponseDTO<List<MenuAccessResponseDto>>
//    getMenuAccessService(Long userId) {
//        long start = System.currentTimeMillis();
//        //check cache first
////        String sessionKey = "tmenu:" + userId;
////        Response sessionValue = redisClientSlave.get(sessionKey);
//        List<MenuAccessResponseDto> lsData;
////        if (sessionValue != null) {
////            //cache found
////            String data = sessionValue.toString();
////            JsonArray jsonData = new JsonArray(data);
////            lsData = jsonData.getList();
////        }
////        else {
//            //cache not found
//            //select * from master.vw_mst_access_menu where user_id=user_id(token)
//            System.out.println("------uid----" + userId);
//            List<ViewMasterAccessMenu> lsMenu = vwMasterAccessMenuRepository.findAllByUserId(String.valueOf(userId));
//            List<String> lsMenuId = new ArrayList<>();
////            System.out.println("--lsmenu-----"+new JsonArray(lsMenu).encodePrettily());
//            for (ViewMasterAccessMenu item : lsMenu) {
//                lsMenuId.add(item.getMenuId());
//            }
//            if (lsMenuId.size() == 0) {
//                return new GenericResponseDTO().noDataFoundResponse();
//            }
//
////            System.out.println("--lsmenuid-----"+new JsonArray(lsMenuId).encodePrettily());
//
//            List<ViewMasterAccessForm> lsEntity = vwMasterAccesFormRepository
//                    .findAllByUserIdAndMenuId(userId, lsMenuId);
//
////            System.out.println("--lsentity-----"+new JsonArray(lsEntity).encodePrettily());
//            ViewMasterAccessForm lastFormData = new ViewMasterAccessForm();
//            lsData = new ArrayList<>();
//            for (ViewMasterAccessForm formData : lsEntity) {
//                if (!formData.getMenuId().equals(lastFormData.getMenuId())) {
////                    System.out.println(String.format("%s -------- %s",lastFormData.getMenuId(),formData.getMenuId()));
//                    lastFormData = formData;
//
//                    //find in menu
//                    String empId = lastFormData.getEmplId();
//                    String menuId = lastFormData.getMenuId();
//                    String description = null;
//                    for (ViewMasterAccessMenu item : lsMenu) {
//                        if (userId == item.getUserId()
//                                && menuId.equals(item.getMenuId())) {
//                            description = item.getDescription();
//                            break;
//                        }
//                    }
//
//                    //if key!=last data then new Dto
//                    MenuAccessResponseDto masterData = new MenuAccessResponseDto();
//                    lsData.add(masterData);
//                    masterData.setMenuId(formData.getMenuId());
//                    masterData.setEmpId(formData.getEmplId());
//                    masterData.setDescription(description);
//                    masterData.setUserId("" + userId);
//                    List<ListFormItem> lsForm = new ArrayList<>();
//                    masterData.setListForm(lsForm);
//                }
//                int dataSize = lsData.size();
//                MenuAccessResponseDto masterData = lsData.get(dataSize - 1);
//                List<ListFormItem> lsForm = masterData.getListForm();
//                ListFormItem newData = new ListFormItem();
//                newData.setEmplId(formData.getEmplId());
//                newData.setId(formData.getId());
//                newData.setMenuId(formData.getMenuId());
//                newData.setDescription(formData.getDescription());
//                newData.setFormId(formData.getFormId());
//                newData.setUserId("" + formData.getUserId());
//                lsForm.add(newData);
//            }
//
//            JsonArray jsonData = new JsonArray(lsData);
////            redisClientMaster.setex(sessionKey, menuAccessTimout, jsonData.encode());
////        }
//        long stop = System.currentTimeMillis();
//        System.out.println(String.format("[[ %s ms]]", (stop - start)));
//        return new GenericResponseDTO().successResponse(lsData);
//    }

    public GenericResponseDTO<List<String[]>> getMenuAcceesRole() {
        try {
            List<ViewMasterRoleAccess> masterRoleAccessList = vwMasterAccessRoleRepository.findAll();

            GenericResponseDTO<List<String[]>> response = new GenericResponseDTO<>();
            List<String[]> dataList = new ArrayList<>();

            int index = 1;
            for (ViewMasterRoleAccess access : masterRoleAccessList) {
                dataList.add(new String[]{
                        String.valueOf(index++),
                        access.getGroupName(),
                        access.getDivisionCode(),
                        access.getKabkotName(),
                        access.getStatus(),
                        access.getGroupId(),
                });
            }

            return response.successResponse(dataList);

        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
            log.info(String.valueOf(JsonObject.mapFrom(
                    LogOpsUtil.getErrorResponse(ProjectType.CRUD, "Security", new Date(), "Rest",
                            String.valueOf(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()), e.getStackTrace()))));
            return new GenericResponseDTO().errorResponse(HttpResponseStatus.NOT_FOUND.code(), e.getLocalizedMessage());
        }
    }


}
