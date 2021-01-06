
define(['accUtils'],
function(accUtils) {
   function InicioAlumnoViewModel() {
    
     this.connected = () => {
       accUtils.announce('InicioAlumno.', 'assertive');
       document.title = "InicioAlumno";
       
     };

     this.disconnected = () => {
       
     };

     this.transitionCompleted = () => {
       
     };
   }

   return InicioAlumnoViewModel;
 }
);
