define({"oj-message":{fatal:"Fatal",error:"Erreur",warning:"Avertissement",info:"Informations",confirmation:"Confirmation","compact-type-summary":"{0}: {1}"},"oj-converter":{summary:"La valeur n'est pas au format attendu.",detail:"Entrez une valeur au format attendu.","plural-separator":", ",hint:{summary:"Exemple : {exampleValue}",detail:"Entrez une valeur au format suivant : '{exampleValue}'.","detail-plural":"Entrez une valeur aux formats suivants : '{exampleValue}'."},optionHint:{detail:"La valeur acceptée pour l'option '{propertyName}' est '{propertyValueValid}'.","detail-plural":"Les valeurs acceptées pour l'option '{propertyName}' sont '{propertyValueValid}'."},optionTypesMismatch:{summary:"Une valeur est obligatoire pour l'option '{requiredPropertyName}' lorsque l'option '{propertyName}' est définie sur '{propertyValue}'."},optionTypeInvalid:{summary:"Aucune valeur du type attendu n'a été fournie pour l'option '{propertyName}'."},optionOutOfRange:{summary:"La valeur {propertyValue} est hors limites pour l'option '{propertyName}'."},optionValueInvalid:{summary:"La valeur non valide '{propertyValue}' a été indiquée pour l'option '{propertyName}'."},number:{decimalFormatMismatch:{summary:"La valeur fournie n'est pas au format numérique attendu."},shortLongUnsupportedParse:{summary:"'short' et 'long' ne sont pas pris en charge pour l'analyse du convertisseur.",detail:"Passez le composant en lecture seule. Les champs de lecture seule n'appellent pas la fonction d'analyse du convertisseur."},currencyFormatMismatch:{summary:"La valeur fournie n'est pas au format de devise attendu."},percentFormatMismatch:{summary:"La valeur fournie n'est pas au format de pourcentage attendu."},invalidNumberFormat:{summary:"La valeur fournie n'est pas un nombre valide.",detail:"Indiquez un nombre valide."}},color:{invalidFormat:{summary:"Format de couleur non valide.",detail:"Spécification d'option de format de couleur non valide."},invalidSyntax:{summary:"Spécification de couleur non valide.",detail:"Entrez une valeur de couleur conforme à la norme CSS3."}},datetime:{datetimeOutOfRange:{summary:"La valeur '{value}' est hors limites pour '{propertyName}'.",detail:"Entrez une valeur comprise entre '{minValue}' et '{maxValue}'.",hour:"heure",minute:"minute",second:"seconde",millisec:"millisecondes",month:"mois",day:"jour",year:"année","month name":"nom du mois",weekday:"jour de la semaine"},dateFormatMismatch:{summary:"La valeur fournie n'est pas au format de date attendu."},invalidTimeZoneID:{summary:"ID de fuseau horaire non valide indiqué : {timeZoneID}."},nonExistingTime:{summary:"L'heure d'entrée n'existe pas car elle tombe pendant le changement d'heure."},missingTimeZoneData:{summary:"Données TimeZone manquantes. Appelez l'élément 'ojs/ojtimezonedata' requis afin de charger les données TimeZone."},timeFormatMismatch:{summary:"La valeur fournie n'est pas au format d'heure attendu."},datetimeFormatMismatch:{summary:"La valeur fournie n'est pas au format de date et d'heure attendu."},dateToWeekdayMismatch:{summary:"Le '{date}' ne tombe pas un '{weekday}'.",detail:"Entrez un jour de la semaine qui correspond à la date."},invalidISOString:{invalidRangeSummary:"La valeur '{value}' est hors limites pour le champ '{propertyName}' dans la chaîne ISO 8601 '{isoStr}'.",summary:"La valeur '{isoStr}' fournie n'est pas une chaîne ISO 8601 valide.",detail:"Fournissez une chaîne ISO 8601 valide."}}},"oj-validator":{length:{hint:{min:"Entrez au moins {min} caractères.",max:"Entrez {max} caractères ou moins.",inRange:"Entrez entre {min} et {max} caractères.",exact:"Entrez {length} caractères."},messageDetail:{tooShort:"Entrez au moins {min} caractères.",tooLong:"N'entrez pas plus de {max} caractères."},messageSummary:{tooShort:"Il y a trop peu de caractères.",tooLong:"Il y a trop de caractères."}},range:{number:{hint:{min:"Entrez un nombre supérieur ou égal à {min}.",max:"Entrez un nombre inférieur ou égal à {max}.",inRange:"Entrez un nombre compris entre {min} et {max}.",exact:"Entrez le nombre {num}."},messageDetail:{rangeUnderflow:"Entrez {min} ou un nombre supérieur.",rangeOverflow:"Entrez {max} ou un nombre inférieur.",exact:"Entrez le nombre {num}."},messageSummary:{rangeUnderflow:"Le nombre est trop faible.",rangeOverflow:"Le nombre est trop élevé."}},datetime:{hint:{min:"Entrez une date et une heure postérieures ou égales au {min}.",max:"Entrez une date et une heure antérieures ou égales au {max}.",inRange:"Entrez une date et une heure comprises entre le {min} et le {max}."},messageDetail:{rangeUnderflow:"Entrez une date postérieure ou égale au {min}.",rangeOverflow:"Entrez une date antérieure ou égale au {max}."},messageSummary:{rangeUnderflow:"La date et l'heure sont antérieures aux date et heure minimales.",rangeOverflow:"La date et l'heure sont postérieures aux date et heure maximales."}},date:{hint:{min:"Entrez une date postérieure ou égale au {min}.",max:"Entrez une date antérieure ou égale au {max}.",inRange:"Entrez une date comprise entre le {min} et le {max}."},messageDetail:{rangeUnderflow:"Entrez une date postérieure ou égale au {min}.",rangeOverflow:"Entrez une date antérieure ou égale au {max}."},messageSummary:{rangeUnderflow:"La date est antérieure à la date minimale.",rangeOverflow:"La date est postérieure à la date maximale."}},time:{hint:{min:"Entrez une heure postérieure ou égale à {min}.",max:"Entrez une heure antérieure ou égale à {max}.",inRange:"Entrez une heure comprise entre {min} et {max}."},messageDetail:{rangeUnderflow:"Entrez une heure identique ou postérieure à {min}.",rangeOverflow:"Entrez une heure identique ou antérieure à {max}."},messageSummary:{rangeUnderflow:"L'heure est antérieure à l'heure minimale.",rangeOverflow:"L'heure est postérieure à l'heure maximale."}}},restriction:{date:{messageSummary:"La date {value} est celle d'une entrée désactivée.",messageDetail:"La date sélectionnée n'est pas disponible. Essayez une autre date."}},regExp:{summary:"Le format est incorrect. ",detail:"Entrez des valeurs autorisées correspondant à cette expression régulière : '{pattern}'."},required:{summary:"La valeur est obligatoire.",detail:"Entrez une valeur."}},"oj-ojEditableValue":{loading:"Chargement",requiredText:"Obligatoire",helpSourceText:"En savoir plus..."},"oj-ojInputDate":{done:"Terminé",cancel:"Annuler",prevText:"Précédent",nextText:"Suiv.",currentText:"Aujourd'hui",weekHeader:"Sem.",tooltipCalendar:"Sélectionner une date.",tooltipCalendarTime:"Sélectionner une date/heure.",tooltipCalendarDisabled:"Option Sélectionner une date désactivée.",tooltipCalendarTimeDisabled:"Sélectionner une date/heure désactivée.",picker:"Sélecteur",weekText:"Semaine",datePicker:"Sélecteur de date",inputHelp:"Appuyez sur la touche de défilement vers le bas ou le haut pour accéder au calendrier.",inputHelpBoth:"Appuyez sur la touche de défilement vers le bas ou le haut pour accéder au calendrier et sur Maj+touche de défilement vers le bas ou le haut pour accéder à la liste déroulante d'heure.",dateTimeRange:{hint:{min:"",max:"",inRange:""},messageDetail:{rangeUnderflow:"",rangeOverflow:""},messageSummary:{rangeUnderflow:"",rangeOverflow:""}},dateRestriction:{hint:"",messageSummary:"",messageDetail:""}},"oj-ojInputTime":{cancelText:"Annuler",okText:"OK",currentTimeText:"Maintenant",hourWheelLabel:"Heure",minuteWheelLabel:"Minute",ampmWheelLabel:"AMPM",tooltipTime:"Sélectionner l'heure.",tooltipTimeDisabled:"Option Sélectionner une heure désactivée.",inputHelp:"Appuyez sur la touche de défilement vers le bas ou le haut pour accéder à la liste déroulante d'heure.",dateTimeRange:{hint:{min:"",max:"",inRange:""},messageDetail:{rangeUnderflow:"",rangeOverflow:""},messageSummary:{rangeUnderflow:"",rangeOverflow:""}}},"oj-inputBase":{required:{hint:"",messageSummary:"",messageDetail:""},regexp:{messageSummary:"",messageDetail:""},accessibleMaxLengthExceeded:"Longueur maximale {len} dépassée.",accessibleMaxLengthRemaining:"{chars} caractères restants."},"oj-ojInputPassword":{regexp:{messageDetail:"La valeur doit correspondre au modèle suivant : '{pattern}'."}},"oj-ojFilmStrip":{labelAccFilmStrip:"Affichage de la page {pageIndex} sur {pageCount}",labelAccArrowNextPage:"Sélectionnez Suivant pour afficher la page suivante",labelAccArrowPreviousPage:"Sélectionnez Précédent pour afficher la page précédente",tipArrowNextPage:"Suivant",tipArrowPreviousPage:"Précédent"},"oj-ojDataGrid":{accessibleSortAscending:"{id} trié par ordre croissant",accessibleSortDescending:"{id} trié par ordre décroissant",accessibleActionableMode:"Passer au mode d'intervention.",accessibleNavigationMode:"Passer au mode de navigation ; appuyer sur F2 pour passer au mode de modification ou d'intervention.",accessibleEditableMode:"Passer au mode de modification ; appuyer sur Echap pour naviguer en dehors de la grille de données.",accessibleSummaryExact:"Il s'agit d'une grille de données avec {rownum} lignes et {colnum} colonnes",accessibleSummaryEstimate:"Il s'agit d'une grille de données avec un nombre inconnu de lignes et de colonnes",accessibleSummaryExpanded:"{num} lignes sont actuellement développées",accessibleRowExpanded:"Ligne développée",accessibleRowCollapsed:"Ligne réduite",accessibleRowSelected:"Ligne {row} sélectionnée",accessibleColumnSelected:"Colonne {column} sélectionnée",accessibleStateSelected:"sélectionné",accessibleMultiCellSelected:"{num} cellules sélectionnées",accessibleColumnSpanContext:"{extent} de large",accessibleRowSpanContext:"{extent} de haut",accessibleRowContext:"Ligne {index}",accessibleColumnContext:"Colonne {index}",accessibleRowHeaderContext:"En-tête de ligne {index}",accessibleColumnHeaderContext:"En-tête de colonne {index}",accessibleRowEndHeaderContext:"En-tête de fin de ligne {index}",accessibleColumnEndHeaderContext:"En-tête de fin de colonne {index}",accessibleRowHeaderLabelContext:"Libellé d'en-tête de ligne {level}",accessibleColumnHeaderLabelContext:"Libellé d'en-tête de colonne {level}",accessibleRowEndHeaderLabelContext:"Libellé d'en-tête de fin de ligne {level}",accessibleColumnEndHeaderLabelContext:"Libellé d'en-tête de fin de colonne {level}",accessibleLevelContext:"Niveau {level}",accessibleRangeSelectModeOn:"Mode Ajouter la plage de cellules sélectionnée activé.",accessibleRangeSelectModeOff:"Mode Ajouter la plage de cellules sélectionnée désactivé.",accessibleFirstRow:"Vous avez atteint la première ligne.",accessibleLastRow:"Vous avez atteint la dernière ligne.",accessibleFirstColumn:"Vous avez atteint la première colonne",accessibleLastColumn:"Vous avez atteint la dernière colonne.",accessibleSelectionAffordanceTop:"Poignée de sélection supérieure.",accessibleSelectionAffordanceBottom:"Poignée de sélection inférieure.",msgFetchingData:"Extraction des données...",msgNoData:"Aucun élément à afficher.",labelResize:"Redimensionner",labelResizeWidth:"Redimensionner la largeur",labelResizeHeight:"Redimensionner la hauteur",labelSortRow:"Trier la ligne",labelSortRowAsc:"Trier la ligne par ordre croissant",labelSortRowDsc:"Trier la ligne par ordre décroissant",labelSortCol:"Trier la colonne",labelSortColAsc:"Trier la colonne par ordre croissant",labelSortColDsc:"Trier la colonne par ordre décroissant",labelCut:"Couper",labelPaste:"Coller",labelEnableNonContiguous:"Activer la sélection non contiguë",labelDisableNonContiguous:"Désactiver la sélection non contiguë",labelResizeDialogSubmit:"OK",labelResizeDialogCancel:"Annuler"},"oj-ojRowExpander":{accessibleLevelDescription:"Niveau {level}",accessibleRowDescription:"Niveau {level}, ligne {num} sur {total}",accessibleRowExpanded:"Ligne développée",accessibleRowCollapsed:"Ligne réduite",accessibleStateExpanded:"développé",accessibleStateCollapsed:"réduit"},"oj-ojListView":{msgFetchingData:"Extraction des données...",msgNoData:"Aucun élément à afficher.",msgItemsAppended:"{count} éléments ajoutés à la fin.",indexerCharacters:"A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z",accessibleReorderTouchInstructionText:"Touchez deux fois et maintenez la pression. Attendez l'émission du son, puis faites glisser pour réorganiser l'écran.",accessibleReorderBeforeItem:"Avant {item}",accessibleReorderAfterItem:"Après {item}",accessibleReorderInsideItem:"Dans {item}",accessibleNavigateSkipItems:"{numSkip} éléments ignorés",labelCut:"Couper",labelCopy:"Copier",labelPaste:"Coller",labelPasteBefore:"Coller avant",labelPasteAfter:"Coller après"},"oj-_ojLabel":{tooltipHelp:"Aide",tooltipRequired:"Obligatoire"},"oj-ojLabel":{tooltipHelp:"Aide",tooltipRequired:"Obligatoire"},"oj-ojInputNumber":{required:{hint:"",messageSummary:"",messageDetail:""},numberRange:{hint:{min:"",max:"",inRange:"",exact:""},messageDetail:{rangeUnderflow:"",rangeOverflow:"",exact:""},messageSummary:{rangeUnderflow:"",rangeOverflow:""}},tooltipDecrement:"Décrémenter",tooltipIncrement:"Incrémenter"},"oj-ojTable":{accessibleColumnContext:"Colonne {index}",accessibleColumnHeaderContext:"En-tête de colonne {index}",accessibleRowContext:"Ligne {index}",accessibleSortable:"{id} triable",accessibleSortAscending:"{id} trié par ordre croissant",accessibleSortDescending:"{id} trié par ordre décroissant",accessibleStateSelected:"sélectionné",labelAccSelectionAffordanceTop:"Poignée de sélection supérieure",labelAccSelectionAffordanceBottom:"Poignée de sélection inférieure",labelEnableNonContiguousSelection:"Activer la sélection non contiguë",labelDisableNonContiguousSelection:"Désactiver la sélection non contiguë",labelResize:"Redimensionner",labelResizePopupSubmit:"OK",labelResizePopupCancel:"Annuler",labelResizePopupSpinner:"Redimensionner la colonne",labelSelectRow:"Sélectionner une ligne",labelEditRow:"Modifier une ligne",labelSelectAndEditRow:"Sélectionner et modifier une ligne",labelSelectColumn:"Sélectionner une colonne",labelSort:"Trier",labelSortAsc:"Trier par ordre croissant",labelSortDsc:"Trier par ordre décroissant",msgFetchingData:"Extraction des données...",msgNoData:"Aucune donnée à afficher.",msgInitializing:"Initialisation...",msgColumnResizeWidthValidation:"La valeur de largeur doit être un entier.",msgScrollPolicyMaxCountSummary:"Nombre maximal de lignes dépassé pour le défilement de table.",msgScrollPolicyMaxCountDetail:"Procédez au rechargement avec un jeu de données plus petit.",msgStatusSortAscending:"{0} trié par ordre croissant.",msgStatusSortDescending:"{0} trié par ordre décroissant."},"oj-ojTabs":{labelCut:"Couper",labelPasteBefore:"Coller avant",labelPasteAfter:"Coller après",labelRemove:"Enlever",labelReorder:"Réorganiser",removeCueText:"Peut être enlevé"},"oj-ojCheckboxset":{readonlyNoValue:"",required:{hint:"",messageSummary:"",messageDetail:""}},"oj-ojRadioset":{readonlyNoValue:"",required:{hint:"",messageSummary:"",messageDetail:""}},"oj-ojSelect":{required:{hint:"",messageSummary:"",messageDetail:""},searchField:"Champ de recherche",noMatchesFound:"Aucune correspondance trouvée",oneMatchesFound:"Une correspondance a été trouvée",moreMatchesFound:"{num} correspondances trouvées",filterFurther:"D'autres résultats sont disponibles, appliquez plus de filtres."},"oj-ojSwitch":{SwitchON:"Activé",SwitchOFF:"Désactivé"},"oj-ojCombobox":{required:{hint:"",messageSummary:"",messageDetail:""},noMatchesFound:"Aucune correspondance trouvée",oneMatchesFound:"Une correspondance a été trouvée",moreMatchesFound:"{num} correspondances trouvées",filterFurther:"D'autres résultats sont disponibles, appliquez plus de filtres."},"oj-ojSelectSingle":{required:{hint:"",messageSummary:"",messageDetail:""},noMatchesFound:"Aucune correspondance trouvée",oneMatchFound:"Une correspondance a été trouvée",multipleMatchesFound:"{num} correspondances trouvées",nOrMoreMatchesFound:"Au moins {num} correspondances trouvées",cancel:"Annuler",labelAccOpenDropdown:"Développer",labelAccClearValue:"Effacer la valeur",noResultsLine1:"Aucun résultat",noResultsLine2:"Aucun élément ne correspond à votre recherche."},"oj-ojInputSearch":{required:{hint:"",messageSummary:"",messageDetail:""},noMatchesFound:"Aucune correspondance trouvée",oneMatchesFound:"Une correspondance a été trouvée",moreMatchesFound:"{num} correspondances trouvées"},"oj-ojTree":{stateLoading:"Chargement...",labelNewNode:"Nouveau noeud",labelMultiSelection:"Sélection multiple",labelEdit:"Modifier",labelCreate:"Créer",labelCut:"Couper",labelCopy:"Copier",labelPaste:"Coller",labelPasteAfter:"Coller après",labelPasteBefore:"Coller avant",labelRemove:"Enlever",labelRename:"Renommer",labelNoData:"Aucune donnée"},"oj-ojPagingControl":{labelAccPaging:"Pagination",labelAccPageNumber:"Contenu de la page {pageNum} chargé",labelAccNavFirstPage:"Première page",labelAccNavLastPage:"Dernière page",labelAccNavNextPage:"Page suivante",labelAccNavPreviousPage:"Page précédente",labelAccNavPage:"Page",labelLoadMore:"Afficher plus...",labelLoadMoreMaxRows:"Limite maximale de {maxRows} lignes atteinte",labelNavInputPage:"Page",labelNavInputPageMax:"sur {pageMax}",fullMsgItemRange:"Eléments {pageFrom}-{pageTo} sur {pageMax}",fullMsgItemRangeAtLeast:"Eléments {pageFrom}-{pageTo} sur au moins {pageMax}",fullMsgItemRangeApprox:"Eléments {pageFrom}-{pageTo} sur environ {pageMax}",msgItemRangeNoTotal:"Eléments {pageFrom}-{pageTo}",fullMsgItem:"{pageTo} éléments sur {pageMax}",fullMsgItemAtLeast:"{pageTo} éléments sur au moins {pageMax}",fullMsgItemApprox:"{pageTo} éléments sur environ {pageMax}",msgItemNoTotal:"{pageTo} éléments",msgItemRangeCurrent:"{pageFrom}-{pageTo}",msgItemRangeCurrentSingle:"{pageFrom}",msgItemRangeOf:"sur",msgItemRangeOfAtLeast:"d'au moins",msgItemRangeOfApprox:"d'environ",msgItemRangeItems:"éléments",tipNavInputPage:"Aller à la page",tipNavPageLink:"Aller à la page {pageNum}",tipNavNextPage:"Suivant",tipNavPreviousPage:"Précédent",tipNavFirstPage:"Premier",tipNavLastPage:"Dernier",pageInvalid:{summary:"La valeur de page saisie n'est pas valide.",detail:"Entrez une valeur supérieure à 0."},maxPageLinksInvalid:{summary:"La valeur de maxPageLinks n'est pas valide.",detail:"Entrez une valeur supérieure à 4."}},"oj-ojMasonryLayout":{labelCut:"Couper",labelPasteBefore:"Coller avant",labelPasteAfter:"Coller après"},"oj-panel":{labelAccButtonExpand:"Développer",labelAccButtonCollapse:"Réduire",labelAccButtonRemove:"Enlever",labelAccFlipForward:"Inverser vers l'avant",labelAccFlipBack:"Réinverser",tipDragToReorder:"Faire glisser pour réorganiser",labelAccDragToReorder:"Faire glisser pour réorganiser, menu contextuel disponible"},"oj-ojChart":{labelDefaultGroupName:"Groupe {0}",labelSeries:"Série",labelGroup:"Groupe",labelDate:"Date",labelValue:"Valeur",labelTargetValue:"Cible",labelX:"X",labelY:"Y",labelZ:"Z",labelPercentage:"Pourcentage",labelLow:"Basse",labelHigh:"Elevée",labelOpen:"Ouverture",labelClose:"Fermeture",labelVolume:"Volume",labelQ1:"Q1",labelQ2:"Q2",labelQ3:"Q3",labelMin:"Valeur minimale",labelMax:"Valeur maximale",labelOther:"Autre",tooltipPan:"Panoramique",tooltipSelect:"Sélection par rectangle de sélection",tooltipZoom:"Zoom par rectangle de sélection",componentName:"Graphique"},"oj-dvtBaseGauge":{componentName:"Jauge"},"oj-ojDiagram":{promotedLink:"{0} lien",promotedLinks:"{0} liens",promotedLinkAriaDesc:"Indirect",componentName:"Diagramme"},"oj-ojGantt":{componentName:"Graphique de Gantt",accessibleDurationDays:"{0} jours",accessibleDurationHours:"{0} heures",accessibleTaskInfo:"Heure de début : {0}, heure de fin : {1}, durée : {2}",accessibleMilestoneInfo:"Heure : {0}",accessibleRowInfo:"Ligne : {0}",accessibleTaskTypeMilestone:"Jalon",accessibleTaskTypeSummary:"Récapitulatif",accessiblePredecessorInfo:"{0} prédécesseurs",accessibleSuccessorInfo:"{0} successeurs",accessibleDependencyInfo:"Type de dépendance {0}, connecte {1} à {2}",startStartDependencyAriaDesc:"début-début",startFinishDependencyAriaDesc:"début-fin",finishStartDependencyAriaDesc:"fin-début",finishFinishDependencyAriaDesc:"fin-fin",tooltipZoomIn:"Zoom avant",tooltipZoomOut:"Zoom arrière",labelLevel:"Niveau",labelRow:"Ligne",labelStart:"Début",labelEnd:"Fin",labelDate:"Date",labelBaselineStart:"Début de référence",labelBaselineEnd:"Fin de référence",labelBaselineDate:"Date de référence",labelLabel:"Libellé",labelProgress:"Progression",labelMoveBy:"Déplacement par",labelResizeBy:"Redimensionnement par",taskMoveInitiated:"Déplacement de tâche lancé",taskResizeEndInitiated:"Redimensionnement de la fin de la tâche lancée",taskResizeStartInitiated:"Redimensionnement du début de la tâche lancé",taskMoveSelectionInfo:"{0} autres éléments sélectionnés",taskResizeSelectionInfo:"{0} autres éléments sélectionnés",taskMoveInitiatedInstruction:"Utilisez les flèches du clavier pour le déplacement",taskResizeInitiatedInstruction:"Utiliser les flèches du clavier pour le redimensionnement",taskMoveFinalized:"Déplacement de tâche finalisé",taskResizeFinalized:"Redimensionnement de tâche finalisé",taskMoveCancelled:"Déplacement de tâche annulé",taskResizeCancelled:"Redimensionnement de tâche annulé",taskResizeStartHandle:"Poignée de redimensionnement du début de la tâche",taskResizeEndHandle:"Poignée de redimensionnement de la fin de tâche"},"oj-ojLegend":{componentName:"Légende",tooltipExpand:"Développer",tooltipCollapse:"Réduire"},"oj-ojNBox":{highlightedCount:"{0}/{1}",labelOther:"Autre",labelGroup:"Groupe",labelSize:"Taille",labelAdditionalData:"Données supplémentaires",componentName:"Zone {0}"},"oj-ojPictoChart":{componentName:"Graphique d'images"},"oj-ojSparkChart":{componentName:"Graphique"},"oj-ojSunburst":{labelColor:"Couleur",labelSize:"Taille",tooltipExpand:"Développer",tooltipCollapse:"Réduire",componentName:"Sunburst"},"oj-ojTagCloud":{componentName:"Nuage de mots-clés"},"oj-ojThematicMap":{componentName:"Carte thématique",areasRegion:"Zones",linksRegion:"Liens",markersRegion:"Marqueurs"},"oj-ojTimeAxis":{componentName:"Axe temporel"},"oj-ojTimeline":{componentName:"Chronologie",accessibleItemDesc:"La description est {0}.",accessibleItemEnd:"L'heure de fin est {0}.",accessibleItemStart:"L'heure de début est {0}.",accessibleItemTitle:"Le titre est {0}.",labelSeries:"Série",tooltipZoomIn:"Zoom avant",tooltipZoomOut:"Zoom arrière",labelStart:"Début",labelEnd:"Fin",labelDate:"Date",labelTitle:"Titre",labelDescription:"Description"},"oj-ojTreemap":{labelColor:"Couleur",labelSize:"Taille",tooltipIsolate:"Isoler",tooltipRestore:"Restaurer",componentName:"Vue Treemap"},"oj-dvtBaseComponent":{labelScalingSuffixThousand:"K",labelScalingSuffixMillion:"M",labelScalingSuffixBillion:"B",labelScalingSuffixTrillion:"T",labelScalingSuffixQuadrillion:"Q",labelInvalidData:"Données non valides",labelNoData:"Aucune donnée à afficher",labelClearSelection:"Effacer la sélection",labelDataVisualization:"Visualisation des données",stateSelected:"Sélectionné",stateUnselected:"Non sélectionné",stateMaximized:"Agrandi",stateMinimized:"Réduit",stateExpanded:"Développé",stateCollapsed:"Réduit",stateIsolated:"Isolé",stateHidden:"Masqué",stateVisible:"Visible",stateDrillable:"Explorable",labelAndValue:"{0}: {1}",labelCountWithTotal:"{0} sur {1}"},"oj-ojNavigationList":{defaultRootLabel:"Liste de navigation",hierMenuBtnLabel:"Bouton de menu hiérarchique",selectedLabel:"sélectionné",previousIcon:"Précédent",msgFetchingData:"Extraction des données...",msgNoData:"Aucun élément à afficher.",overflowItemLabel:"Plus",accessibleReorderTouchInstructionText:"Touchez deux fois et maintenez la pression. Attendez l'émission du son, puis faites glisser pour réorganiser l'écran.",accessibleReorderBeforeItem:"Avant {item}",accessibleReorderAfterItem:"Après {item}",labelCut:"Couper",labelPasteBefore:"Coller avant",labelPasteAfter:"Coller après",labelRemove:"Enlever",removeCueText:"Peut être enlevé"},"oj-ojSlider":{noValue:"ojSlider n'a aucune valeur",maxMin:"La valeur maximale ne doit pas être inférieure ou égale à la valeur minimale",startEnd:"value.start ne doit pas être supérieure à value.end",valueRange:"La valeur doit être comprise dans la plage des valeurs minimales à maximales",optionNum:"L'option {option} n'est pas un nombre",invalidStep:"Etape non valide. Elle doit être > 0",lowerValueThumb:"curseur de valeur inférieure",higherValueThumb:"curseur de valeur supérieure"},"oj-ojDialog":{labelCloseIcon:"Fermeture"},"oj-ojPopup":{ariaLiveRegionInitialFocusFirstFocusable:"Accès à la fenêtre instantanée. Appuyez sur F6 pour naviguer entre la fenêtre instantanée et le contrôle associé.",ariaLiveRegionInitialFocusNone:"Fenêtre instantanée ouverte. Appuyez sur F6 pour naviguer entre la fenêtre instantanée et le contrôle associé.",ariaLiveRegionInitialFocusFirstFocusableTouch:"Accès à la fenêtre instantanée. Pour fermer cette fenêtre, accédez au dernier lien qu'elle contient.",ariaLiveRegionInitialFocusNoneTouch:"Fenêtre instantanée ouverte. Accédez au lien suivant pour définir le focus dans la fenêtre instantanée.",ariaFocusSkipLink:"Touchez deux fois pour accéder à la fenêtre instantanée ouverte.",ariaCloseSkipLink:"Touchez deux fois pour fermer la fenêtre instantanée ouverte."},"oj-ojRefresher":{ariaRefreshLink:"Activer le lien pour actualiser le contenu",ariaRefreshingLink:"Actualisation du contenu",ariaRefreshCompleteLink:"Actualisation terminée"},"oj-ojSwipeActions":{ariaShowStartActionsDescription:"Afficher les actions de début",ariaShowEndActionsDescription:"Afficher les actions de fin",ariaHideActionsDescription:"Masquer les actions"},"oj-ojIndexer":{indexerCharacters:"A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z",indexerOthers:"#",ariaDisabledLabel:"Aucun en-tête de groupe correspondant",ariaOthersLabel:"nombre",ariaInBetweenText:"Entre {first} et {second}",ariaKeyboardInstructionText:"Appuyez sur Entrée pour sélectionner une valeur.",ariaTouchInstructionText:"Touchez deux fois et maintenez le toucher pour passer en mode d'opération, puis faites glisser vers le haut ou le bas pour ajuster la valeur."},"oj-ojMenu":{labelCancel:"Annuler",ariaFocusSkipLink:"Le focus est dans le menu, touchez deux fois ou faites glisser le focus pour le déplacer vers le premier élément de menu."},"oj-ojColorSpectrum":{labelHue:"Teinte",labelOpacity:"Opacité",labelSatLum:"Saturation/Luminance",labelThumbDesc:"Curseur quadridirectionnel du spectre de couleurs."},"oj-ojColorPalette":{labelNone:"Aucun"},"oj-ojColorPicker":{labelSwatches:"Echantillons de couleur",labelCustomColors:"Couleurs personnalisées",labelPrevColor:"Couleur précédente",labelDefColor:"Couleur par défaut",labelDelete:"Supprimer",labelDeleteQ:"Supprimer ?",labelAdd:"Ajouter",labelAddColor:"Ajouter une couleur",labelMenuHex:"HEX",labelMenuRgba:"RGBa",labelMenuHsla:"HSLa",labelSliderHue:"Teinte",labelSliderSaturation:"Saturation",labelSliderSat:"Sat",labelSliderLightness:"Clarté",labelSliderLum:"Luminosité",labelSliderAlpha:"Alpha",labelOpacity:"Opacité",labelSliderRed:"Rouge",labelSliderGreen:"Vert",labelSliderBlue:"Bleu"},"oj-ojFilePicker":{dropzoneText:"Déplacer les fichiers ici ou cliquer pour les télécharger",singleFileUploadError:"Téléchargez un fichier à la fois.",singleFileTypeUploadError:"Vous ne pouvez pas télécharger des fichiers de type {fileType}.",multipleFileTypeUploadError:"Vous ne pouvez pas télécharger des fichiers de type {fileTypes}.",dropzonePrimaryText:"Glisser-déplacer",secondaryDropzoneText:"Sélectionner un fichier ou en déplacer un ici.",secondaryDropzoneTextMultiple:"Sélectionner des fichiers ou en déplacer ici.",unknownFileType:"inconnu"},"oj-ojProgressbar":{ariaIndeterminateProgressText:"En cours"},"oj-ojMessage":{labelCloseIcon:"Fermeture",categories:{error:"Erreur",warning:"Avertissement",info:"Informations",confirmation:"Confirmation"}},"oj-ojSelector":{checkboxAriaLabel:"Sélection de case à cocher {rowKey}"},"oj-ojMessages":{labelLandmark:"Messages",ariaLiveRegion:{navigationFromKeyboard:"Accès à la région des messages. Appuyez sur F6 pour revenir à l'élément sélectionné précédent.",navigationToTouch:"La région des messages en comporte de nouveaux. Utilisez le rotor de commande vocale pour accéder au repère des messages.",navigationToKeyboard:"La région des messages en comporte de nouveaux. Appuyez sur F6 pour revenir à la région du message le plus récent.",newMessage:"Catégorie de message {category}. {summary}. {detail}."}}});