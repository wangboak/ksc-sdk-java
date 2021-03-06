package com.ksc.network.vpc;

import com.ksc.network.vpc.model.SecurityGroups.AuthorizeSecurityGroupEntryRequest;
import com.ksc.network.vpc.model.SecurityGroups.AuthorizeSecurityGroupEntryResult;
import com.ksc.network.vpc.model.SecurityGroups.CreateSecurityGroupRequest;
import com.ksc.network.vpc.model.SecurityGroups.CreateSecurityGroupResult;
import com.ksc.network.vpc.model.SecurityGroups.DeleteSecurityGroupRequest;
import com.ksc.network.vpc.model.SecurityGroups.DeleteSecurityGroupResult;
import com.ksc.network.vpc.model.SecurityGroups.DescribeSecurityGroupsRequest;
import com.ksc.network.vpc.model.SecurityGroups.DescribeSecurityGroupsResult;
import com.ksc.network.vpc.model.SecurityGroups.ModifySecurityGroupRequest;
import com.ksc.network.vpc.model.SecurityGroups.ModifySecurityGroupResult;
import com.ksc.network.vpc.model.SecurityGroups.RevokeSecurityGroupEntryRequest;
import com.ksc.network.vpc.model.SecurityGroups.RevokeSecurityGroupEntryResult;
import com.ksc.network.vpc.model.subnet.CreateSubnetRequest;
import com.ksc.network.vpc.model.subnet.CreateSubnetResult;
import com.ksc.network.vpc.model.subnet.DeleteSubnetRequest;
import com.ksc.network.vpc.model.subnet.DeleteSubnetResult;
import com.ksc.network.vpc.model.subnet.DescribeSubnetsRequest;
import com.ksc.network.vpc.model.subnet.DescribeSubnetsResult;
import com.ksc.network.vpc.model.vpc.CreateVpcRequest;
import com.ksc.network.vpc.model.vpc.CreateVpcResult;
import com.ksc.network.vpc.model.vpc.DeleteVpcRequest;
import com.ksc.network.vpc.model.vpc.DeleteVpcResult;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.ksc.auth.AWSCredentials;
import com.ksc.auth.BasicAWSCredentials;
import com.ksc.model.Filter;
import com.ksc.network.vpc.model.DescribeInternetGatewaysRequest;
import com.ksc.network.vpc.model.DescribeInternetGatewaysResult;
import com.ksc.network.vpc.model.DescribeNetworkInterfacesRequest;
import com.ksc.network.vpc.model.DescribeNetworkInterfacesResult;
import com.ksc.network.vpc.model.vpc.DescribeVpcsRequest;
import com.ksc.network.vpc.model.vpc.DescribeVpcsResult;


public class KSCVPCClientTest {
	private static final Logger log = Logger.getLogger(KSCVPCClientTest.class);
	private AWSCredentials credentials = new BasicAWSCredentials("AKLTcI-Ek8zhT-mWMBhNYN_xkg111111",
			"OD0g8h/czdeVy+z/oCOk031yKpVWbAFJVddvFHd87D/L9Tb/tmia8tRJiaAmdyqy4w==");;
	/*@BeforeClass
	public void before() {
		
	}*/
	@Test
	public void DescribeVpcs(){
		KSCVPCClient client=new KSCVPCClient();
		client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
		client.setServiceNameIntern("vpc");
		DescribeVpcsRequest request=new DescribeVpcsRequest();
		//request.withVpcIds("147d81eb-f780-434d-8355-dc125013520e");
		DescribeVpcsResult result=client.describeVpcs(request);
		Assert.assertNotNull(result.getVpcSet());
		log.debug(result);
	}
	@Test
	public void DescribeNetworkInterfaces(){
		KSCVPCClient client=new KSCVPCClient();
		client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
		client.setServiceNameIntern("vpc");
		DescribeNetworkInterfacesRequest request=new DescribeNetworkInterfacesRequest();
		request.withNetworkInterfaceIds("65a5a408-2fad-46cb-8718-ee043add87a2");
		//request.withVpcIds("147d81eb-f780-434d-8355-dc125013520e");
		DescribeNetworkInterfacesResult result=client.describeNetworkInterfaces(request);
		log.info(result);
	}
	@Test
	public void DescribeSubnets(){
		KSCVPCClient client=new KSCVPCClient();
		client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
		client.setServiceNameIntern("vpc");
		DescribeSubnetsRequest request=new DescribeSubnetsRequest();
		request.withSubnetIds("b05b8331-1b45-4c98-822f-718c8ea08e54");
		Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);
		DescribeSubnetsResult result=client.describeSubnets(request);
		log.info(result);
	}
	@Test
	public void DescribeSecurityGroups(){
		KSCVPCClient client=new KSCVPCClient();
		client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
		client.setServiceNameIntern("vpc");
		DescribeSecurityGroupsRequest request=new DescribeSecurityGroupsRequest();
		request.withSecurityGroupIds("9ba12977-5fd0-4211-877b-03d3e550f64e");
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
		DescribeSecurityGroupsResult result=client.describeSecurityGroups(request);
		log.info(result);
	}
	@Test
	public void DescribeInternetGateways(){
		KSCVPCClient client=new KSCVPCClient();
		client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
		client.setServiceNameIntern("vpc");
		DescribeInternetGatewaysRequest request=new DescribeInternetGatewaysRequest();
		request.withInternetGatewayIds("d22fdf17-56ba-4af6-b269-dc060ea98133");
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
		DescribeInternetGatewaysResult result=client.describeInternetGateways(request);
		log.info(result);
	}

    @Test
    public void createVpc(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        CreateVpcRequest request= new CreateVpcRequest();
        request.setVpcName("sdk-test");
        request.setCidrBlock("10.0.0.0/16");
        request.setDefault(false);
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        CreateVpcResult result=client.createVpc(request);
        log.info(result);
    }
    
    @Test
    public void deleteVpc(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        DeleteVpcRequest request= new DeleteVpcRequest();
        request.setVpcId("19e435f8-1b37-49f0-b2a4-c9b65e8cd00b");
        /*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        DeleteVpcResult result=client.deleteVpc(request);
        log.info(result);
    }
    
    @Test
    public void createSubnet(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        CreateSubnetRequest request= new CreateSubnetRequest();
        request.setVpcId("3a256bbe-062a-4120-a3c3-0e2fc49bd5ff");
        request.setCidrBlock("10.0.0.0/16");
        request.setSubnetType("Normal");
        request.setDhcpIpFrom("10.0.0.5");
        request.setDhcpIpTo("10.0.0.20");
        request.setGatewayIp("10.0.0.1");
        request.setDns1("2.2.2.2");
        request.setDns2("3.3.3.3");
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        CreateSubnetResult result=client.createSubnet(request);
        log.info(result);
    }
    
    @Test
    public void deleteSubnet(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        DeleteSubnetRequest request= new DeleteSubnetRequest();
        request.setSubnetId("0107529a-4f68-4457-84e2-14cb0dbccea9");
        /*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        DeleteSubnetResult result=client.deleteSubnet(request);
        log.info(result);
    }
    
    @Test
    public void createSecurityGroup(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        CreateSecurityGroupRequest request= new CreateSecurityGroupRequest();
        request.setVpcId("3f8737a9-31d8-45b1-afe8-e4d87af24d0f");
        request.setSecurityGroupName("abc_SecurityGroup");
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        CreateSecurityGroupResult result=client.createSecurityGroup(request);
        log.info(result);
    }
    
    @Test
    public void deleteSecurityGroup(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        DeleteSecurityGroupRequest request= new DeleteSecurityGroupRequest();
        request.setSecurityGroupId("3a8ac5c9-c111-4672-a15b-5fe29e7aa7ac");
        /*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        DeleteSecurityGroupResult result=client.deleteSecurityGroup(request);
        log.info(result);
    }
    
    @Test
    public void modifySecurityGroup(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        ModifySecurityGroupRequest request= new ModifySecurityGroupRequest();
        request.setSecurityGroupId("063ef9c4-30e1-439c-a2ef-4e794e74828b");
        request.setSecurityGroupName("abc_SecurityGroup");
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        ModifySecurityGroupResult result=client.modifySecurityGroup(request);
        log.info(result);
    }
    
    @Test
    public void authorizeSecurityGroupEntry(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        AuthorizeSecurityGroupEntryRequest request= new AuthorizeSecurityGroupEntryRequest();
        request.setSecurityGroupId("2e369115-171a-45f4-92f4-c860190ba539");
        request.setCidrBlock("20.20.20.0/26");
        request.setDirection("out");
        request.setProtocol("icmp");
        request.setIcmpType(9);
        request.setIcmpCode(22);
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        AuthorizeSecurityGroupEntryResult result=client.authorizeSecurityGroupEntry(request);
        log.info(result);
    }
    
    @Test
    public void revokeSecurityGroupEntry(){
        KSCVPCClient client=new KSCVPCClient();
        client.setEndpoint("http://vpc.cn-shanghai-3.api.ksyun.com");
        client.setServiceNameIntern("vpc");
        RevokeSecurityGroupEntryRequest request= new RevokeSecurityGroupEntryRequest();
        request.setSecurityGroupId("2e369115-171a-45f4-92f4-c860190ba539");
        request.setSecurityGroupEntryId("a652d9e8-174f-4f9a-8f67-42826290506c");
		/*Filter filter=new Filter();
		filter.setName("vpc-id");
		filter.withValues("147d81eb-f780-434d-8355-dc125013520e");
		request.withFilters(filter);*/
        RevokeSecurityGroupEntryResult result=client.revokeSecurityGroupEntry(request);
        log.info(result);
    }
}
