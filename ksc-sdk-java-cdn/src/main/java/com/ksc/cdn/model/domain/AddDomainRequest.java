package com.ksc.cdn.model.domain;

import com.ksc.cdn.model.valid.FieldValidate;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/** 添加域名基础信息参数bean
 * Created by jiangran on 9/18/16.
 */
public class AddDomainRequest {
    @FieldValidate
    private String DomainName;
    @FieldValidate
    private String CdnType;
    private String CdnSubType;
    @FieldValidate
    private String CdnProtocol;
    private String Regions;
    @FieldValidate
    private String OriginType;
    @FieldValidate
    private String OriginProtocol;
    private Integer OriginPort;
    @FieldValidate
    private String Origin;

    public String getDomainName() {
        return DomainName;
    }

    public void setDomainName(String domainName) {
        DomainName = domainName;
    }

    public String getCdnType() {
        return CdnType;
    }

    public void setCdnType(String cdnType) {
        CdnType = cdnType;
    }

    public String getCdnSubType() {
        return CdnSubType;
    }

    public void setCdnSubType(String cdnSubType) {
        CdnSubType = cdnSubType;
    }

    public String getCdnProtocol() {
        return CdnProtocol;
    }

    public void setCdnProtocol(String cdnProtocol) {
        CdnProtocol = cdnProtocol;
    }

    public String getRegions() {
        return Regions;
    }

    public void setRegions(String regions) {
        Regions = regions;
    }

    public String getOriginType() {
        return OriginType;
    }

    public void setOriginType(String originType) {
        OriginType = originType;
    }

    public String getOriginProtocol() {
        return OriginProtocol;
    }

    public void setOriginProtocol(String originProtocol) {
        OriginProtocol = originProtocol;
    }

    public Integer getOriginPort() {
        return OriginPort;
    }

    public void setOriginPort(Integer originPort) {
        OriginPort = originPort;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }
    public Map<String,String> buildParams(){
        Map<String,String> params=new HashMap<String, String>();

        if(StringUtils.isNotBlank(DomainName))
            params.put("DomainName",DomainName);
        if(StringUtils.isNotBlank(CdnType))
            params.put("CdnType",CdnType);
        if(StringUtils.isNotBlank(CdnSubType))
            params.put("CdnSubType",CdnSubType);
        if(StringUtils.isNotBlank(CdnProtocol))
            params.put("CdnProtocol",CdnProtocol);
        if(StringUtils.isNotBlank(Regions))
            params.put("Regions",Regions);
        if(StringUtils.isNotBlank(OriginType))
            params.put("OriginType",OriginType);
        if(StringUtils.isNotBlank(OriginProtocol))
            params.put("OriginProtocol",OriginProtocol);
        if(OriginPort!=null&&OriginPort>0)
            params.put("OriginPort",String.valueOf(OriginPort));
        if(StringUtils.isNotBlank(Origin))
            params.put("Origin",Origin);

        return params;
    }
    private void validField(){

    }
}
