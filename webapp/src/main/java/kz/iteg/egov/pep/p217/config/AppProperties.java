package kz.iteg.egov.pep.p217.config;

import kz.inessoft.egov.pep.core.config.ApplicationVerificationType;
import kz.inessoft.egov.pep.core.config.PaymentType;
import kz.inessoft.egov.pep.core.config.SmsSigningType;
import kz.inessoft.egov.pep.security.context.UserRole;
import kz.inessoft.egov.pep.service.shep2.channel.common.ShepOptions;
import kz.inessoft.egov.pep.util.LocalizedResource;
import kz.inessoft.egov.pep.util.LocalizedValues;
import kz.inessoft.egov.pep.util.Options;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmitry Ruchko
 */
public class AppProperties extends kz.inessoft.egov.pep.core.config.AppProperties {

    private static final LocalizedResource APP_CONFIG_BUNDLE = new LocalizedResource("app-p2-17-config");

    @Override
    public String getAppCode() {
        return "P2.17";
    }

    @Override
    public LocalizedValues getName() {
        return APP_CONFIG_BUNDLE.getResource("app.name");
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.FREE;
    }

    @Override
    public String getGoTargetServiceName() {
        return "P613SyncSrvc";
    }

    @Override
    public String getHedDocTemplateName() {
        return "P2.17";
    }

    @Override
    public String getHedStatusDocGeneratorRouteId() {
        return "R_P6.31";
    }

    @Override
    public String getHedDocTemplateVersion() {
        return null;
    }

    @Override
    public boolean isSendingToGoSync() {
        return true;
    }

    @Override
    public boolean isSendToEmail() {
        return false;
    }

//    @Override
//    public boolean isCaptchaRequired() {
//        return false;
//    }

    @Override
    public SmsSigningType getSmsSigningType() {
        return SmsSigningType.SIGNED_BY_PERSON;
    }

    @Override
    public Set<ApplicationVerificationType> getVerificationTypes() {
        Set<ApplicationVerificationType> verificationTypes = new HashSet<>();
        verificationTypes.add(ApplicationVerificationType.OTP);
        verificationTypes.add(ApplicationVerificationType.EDS);
        verificationTypes.add(ApplicationVerificationType.M_EDS);
        return verificationTypes;
    }

    @Override
    public Options getShepOptions() {
        return new ShepOptions.Builder().wrapByTagDataOnlyRequest().storeSenderId("").build();
    }

    @Override
    public String getMSignRouteId() {
        return "R_P6.31";
    }

    @Override
    public Set<UserRole> getAccessRoles() {
        Set<UserRole> roles = new HashSet<>();

        roles.add(UserRole.USER_FL);
        roles.add(UserRole.SERVICE_CENTER_OPERATOR);

        return roles;
    }
}
