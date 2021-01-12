/**
 * @license
 * Copyright (c) 2014, 2020, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
/*
 * Your application specific code will go here
 */
define(['ojs/ojresponsiveutils', 'ojs/ojresponsiveknockoututils', 'knockout', 'ojs/ojknockout', 
        'ojs/ojinputtext', 'ojs/ojlabel', 'ojs/ojformlayout', 'ojs/ojdatetimepicker', 'ojs/ojradioset',
        'ojs/ojselectcombobox', 'ojs/ojinputnumber', 'ojs/ojswitch', 'ojs/ojbutton'],
  function(ResponsiveUtils, ResponsiveKnockoutUtils, ko) {
     function ControllerViewModel() {

      
      var self = this;

      self.isSmall = ResponsiveKnockoutUtils.createMediaQueryObservable(
        ResponsiveUtils.getFrameworkQuery(ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY));

      self.statesColumns = ko.computed(function () {
        return self.isSmall() ? 1 : 3;
      }.bind(self));

      // Media queries for repsonsive layouts
      const smQuery = ResponsiveUtils.getFrameworkQuery(ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY);
      this.smScreen = ResponsiveKnockoutUtils.createMediaQueryObservable(smQuery);

      self.value1 = ko.observable('IS');
      self.var_nombre = ko.observable('');
      self.var_Ap = ko.observable('');
      self.var_Am = ko.observable('');
      self.var_fecha = ko.observable();
      self.var_genero = ko.observable('Masculino');
      self.var_correo = ko.observable('');
      self.var_contra = ko.observable('');
      self.var_obser = ko.observable('');

      self.clicAceptar = function () {

        alert(self.var_nombre() + ", " + self.var_Ap() + ", " + self.var_Am() + ", " + self.var_fecha() +
              self.var_genero() + ", " + ", " + self.var_correo() + 
              self.var_contra() + ", " + self.var_obser());
      };

      // Header
      // Application Name used in Branding Area
      this.appName = ko.observable("App Name");
      // User Info used in Global Navigation area
      this.userLogin = ko.observable("john.hancock@oracle.com");

      // Footer      
      this.footerLinks = [
        {name: 'About Oracle', linkId: 'aboutOracle', linkTarget:'http://www.oracle.com/us/corporate/index.html#menu-about'},
        { name: "Contact Us", id: "contactUs", linkTarget: "http://www.oracle.com/us/corporate/contact/index.html" },
        { name: "Legal Notices", id: "legalNotices", linkTarget: "http://www.oracle.com/us/legal/index.html" },
        { name: "Terms Of Use", id: "termsOfUse", linkTarget: "http://www.oracle.com/us/legal/terms/index.html" },
        { name: "Your Privacy Rights", id: "yourPrivacyRights", linkTarget: "http://www.oracle.com/us/legal/privacy/index.html" },
      ];
     }

     return new ControllerViewModel();
  }
);
