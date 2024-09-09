package com.eksad.authentication.common;


import com.eksad.authentication.dto.LogOpsDTO;
import com.eksad.authentication.dto.LogResponseDTO;

import java.util.Date;

/**
 *
 * @author amy
 */
public class LogOpsUtil {

    public static LogOpsDTO getLogOps(ProjectType projectType, String domain, String domainClass, String domainParty, Date timeEvent, String eventType, String eventOps, String user, Object data) {
        return new LogOpsDTO(projectType.name() + domain, projectType.name() + domain + ".Request", domainClass, domainParty, timeEvent, domain + "." + eventType, domain + "." + eventOps, user, data);
    }

    public static LogResponseDTO getLogResponse(ProjectType projectType, String domain, Date timeEvent, String eventType, String eventOpsHttp, Object data) {
        return new LogResponseDTO(projectType.name() + domain, projectType.name() + domain + ".Response", timeEvent, domain + "." + eventType + ".SUCCESS", eventOpsHttp, data);
    }

    public static LogResponseDTO getErrorResponse(ProjectType projectType, String domain, Date timeEvent, String eventType, String eventOpsHttp, Object data) {
        return new LogResponseDTO(projectType.name() + domain, projectType.name() + domain + ".Response", timeEvent, domain + "." + eventType + ".ERROR", eventOpsHttp, data);
    }
}
