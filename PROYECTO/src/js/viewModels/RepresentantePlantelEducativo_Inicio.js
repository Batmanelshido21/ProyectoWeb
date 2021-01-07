
define(['accUtils'],
function(accUtils) {
   function InicioAlumnoViewModel() {
    
     this.connected = () => {
       accUtils.announce('InicioRepresentantePlantelEducativo.', 'assertive');
       document.title = "InicioRepresentantePlantelEducativo";
       
     };

     this.disconnected = () => {
       
     };

     this.transitionCompleted = () => {
       
     };
   }

   return InicioAlumnoViewModel;
 }
);