/*
 * Copyright 2016 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.application.webconfig;

import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.resource.Auditable;
import com.stormpath.sdk.resource.Resource;
import com.stormpath.sdk.resource.Saveable;
import com.stormpath.sdk.tenant.Tenant;

/**
 * A WebConfiguration resource is used to configure how the {@link Application} owner of {@link ApplicationWebConfig this}
 * resource, to act as server less client.
 *
 * @since 1.2.0
 */
public interface ApplicationWebConfig extends Resource, Saveable, Auditable {

    /**
     * Returns the WebConfiguration's Domain name, this is automatically generated by Stormpath (using the {@link #getDnsLabel() value}
     * and is guaranteed to be unique across all {@link com.stormpath.sdk.tenant.Tenant tenants} in Stormpath.
     *
     * @return the WebConfiguration's Domain name value or {@code null} if one hasn't been generated for {@code this}
     * resource.
     */
    String getDomainName();

    /**
     * Returns the current dnsLabel or {@code null} if none has been set.
     *
     * @return the current dnsLabel or {@code null} if none has been set.
     */
    String getDnsLabel();

    /**
     * Sets the preferred dnsLabel of the client api domain name.
     * <p/>
     * Warning: Changing this value will override the {@link #getDomainName() domainName} value.
     *
     * @param dnsLabel to
     */
    void setDnsLabel(String dnsLabel);

    /**
     * Returns the webConfiguration's status. Users won't be able to use the applications' api if the webConfiguration is
     * disabled.
     *
     * @return the webConfiguration's status.
     */
    ApplicationWebConfigStatus getStatus();

    /**
     * Sets the webConfiguration's status. Users won't be able to use the applications' api if the webConfiguration is
     * disabled.
     *
     * @param status the webConfiguration's status.
     */
    void setStatus(ApplicationWebConfigStatus status);

    /**
     * @return the {@link ApiKey ap}
     */
    ApiKey getSigningApiKey();

    /**
     * Sets the {@link ApiKey apiKey} to be used by Stormpath when signing tokens issues using the Client API.
     *
     * @param apiKey
     */
    void setSigningApiKey(ApiKey apiKey);

    /**
     * Returns the WebConfiguration's parent ${@link Application application}
     *
     * @return the WebConfiguration's parent ${@link Application application}
     */
    Application getApplication();

    /**
     * Returns the WebConfiguration's parent (owning) Tenant.
     *
     * @return the WebConfiguration's parent (owning) Tenant.
     */
    Tenant getTenant();

    /**
     * Property to configure
     *
     * @return {@link Oauth2Config property}
     */
    Oauth2Config getOAuth2Config();

    /**
     * Returns the configured value for the {@code accessTokenCookie} name.
     *
     * @return returns the configured value for the {@code accessTokenCookie} name.
     */
    CookieConfig getAccessTokenCookieConfig();

    /**
     * Returns the configured value for the {@code refreshTokenCookie} name.
     *
     * @return returns the configured value for the {@code refreshTokenCookie} name.
     */
    CookieConfig getRefreshTokenCookieConfig();

    /**
     * @return {@link WebFeatureConfig property} value of the register control.
     */
    RegisterConfig getRegisterConfig();

    /**
     * Property that controls the logic that must exist in order to facilitate self-service verification of newly
     * registered user accounts.
     *
     * @return {@link WebFeatureConfig property} value of the verifyEmail control.
     */
    VerifyEmailConfig getVerifyEmailConfig();

    /**
     * Property that controls the  logic that must exist in order to facilitate self-service login of user accounts.
     *
     * @return {@link WebFeatureConfig property} value of the login control.
     */
    LoginConfig getLoginConfig();

    /**
     * Property that controls the  logic endpoint is used to delete the Authentication Cookies that were set on login.
     * The access and refresh tokens that were issued (and stored in cookies) must also be deleted from the
     * Stormpath REST API.
     *
     * @return {@link LogoutConfig logoutConfig} value of the logout control.
     */
    LogoutConfig getLogoutConfig();

    /**
     * Property that controls the  logic that must exist in order to facilitate self-service login of user accounts.
     *
     * @return {@link WebFeatureConfig property} value of forgotPa control.
     */
    ForgotPasswordConfig getForgotPasswordConfig();

    /**
     * Property that controls the  logic that must exist in order to facilitate self-service login of user accounts.
     *
     * @return {@link WebFeatureConfig property} value of the changePassword control.
     */
    ChangePasswordConfig getChangePasswordConfig();

    /**
     * Property that controls the  logic that must exist in order to facilitate self-service idSite of user accounts.
     *
     * @return {@link WebFeatureConfig property} value of the idSite control.
     */
    IdSiteConfig getIdSiteConfig();

    /**
     * Property that controls the  logic that must exist in order to facilitate self-service callback of user accounts.
     *
     * @return {@link WebFeatureConfig property} value of the callback control.
     */
    CallbackConfig getCallbackConfig();

    /**
     * Property that controls  the logic that allows the client application to fetch the account object of the currently
     * authenticated user.
     *
     * @return {@link MeConfig property} value of the me control.
     */
    MeConfig getMeConfig();
}