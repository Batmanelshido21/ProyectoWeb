
define(['knockout', 'ojs/ojbootstrap', 'ojs/ojarraydataprovider', 'ojs/ojknockout', 'ojs/ojtable', 'ojs/ojbutton'],
function(accUtils, ko, Bootstrap, ArrayDataProvider) {
   function ViewModel() {

    var self = this;

    var listdocs = [];

    self.dataprovider = ko.observable();
    self.dataprovider(new ArrayDataProvider(listdocs, { keyAttributes: 'nombre', implicitSort: [{ attribute: 'nombre', direction: 'ascending' }] }));   
    
     this.connected = () => {
       accUtils.announce('ActividadesDeAlumno.', 'assertive');
       document.title = "ActividadesDeAlumno";
       var self = this;

       var listdocs = [];
   
       self.dataprovider = ko.observable();
       self.dataprovider(new ArrayDataProvider(listdocs, { keyAttributes: 'nombre', implicitSort: [{ attribute: 'nombre', direction: 'ascending' }] }));   
       
     };

     this.disconnected = () => {
       
     };

     this.transitionCompleted = () => {
       
     };
   }

   var vm = new ViewModel();
  
    Bootstrap.whenDocumentReady().then(
      function () {
        try{
          ko.applyBindings(vm, document.getElementById('tablaWrapper'));
        }catch{}
      }
    );

   return vm;
 }
);