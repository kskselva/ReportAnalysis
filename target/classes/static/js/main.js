


function showAlert(alertMessage) {
	
$("body").overhang({
		  type: "success",
		  message: alertMessage
		});

}

function showWarn(alertMessage) {
	
	$("body").overhang({
			  type: "warn",
			  message: alertMessage
			});

	}

function resetMessage() {
	event.preventDefault();
	highlights = [];
	solutionSupport = [];
	proactiveEngagement = [];
	deliverySupport = [];
	labActivity = [];
	poC = [];
	customerVisit = [];
	internalActivities = [];
	certification = [];
	trainingConducted = [];
	trainingAttended = [];
	partnership = [];
	OEMMeet = [];
	showAlert("Form Reset Complete");
	
}


var highlights = [];

function saveHighlights() {
	event.preventDefault();
	
	var temp =constructHighlights();
	
	if (temp.highlights != '')
	{
	highlights.push(temp);
	
	
	//console.log(highlights);
	showAlert("Saved Highlights");
	
	}
	
	else
		showWarn("Type something and try again");
	
	
}
var solutionSupport = [];

function saveSolutionSupport() {
	event.preventDefault();
	solutionSupport.push(constructSS());
	console.log(solutionSupport);
	showAlert("Saved Solution Support");
}

var proactiveEngagement = [];

function saveProactiveEngagement() {
	event.preventDefault();
	proactiveEngagement.push(constructPE());
	console.log(proactiveEngagement);
	showAlert("Saved Proactive Engagement");
}

var deliverySupport = [];

function saveDeliverySupport() {
	event.preventDefault();
	deliverySupport.push(constructDS());
	console.log(deliverySupport);
	showAlert("Saved Delivery Support");
}

var labActivity = [];

function saveLabActivity() {
	event.preventDefault();
	labActivity.push(constructLabActivity());
	console.log(labActivity);
	showAlert("Saved Lab Activities");
}

var poC = [];

function savePoC() {
	showAlert("Saved PoC");

	event.preventDefault();
	poC.push(constructPOC());
	console.log(poC);
	showAlert("Saved PoC");
}

var customerVisit = [];

function saveCustomerVisit() {
	event.preventDefault();
	customerVisit.push(constructCustomerVisited());
	console.log(customerVisit);
	showAlert("Saved Customer Visit");
}

var internalActivities = [];

function saveInternalActivities() {
	event.preventDefault();
	internalActivities.push(constructInternalActivities());
	console.log(internalActivities);
	showAlert("Saved Internal Activities");
}

var certification = [];

function saveCertification() {
	event.preventDefault();
	certification.push(constructCertification());
	console.log(certification);
	showAlert("Saved Certification");
}

var trainingConducted = [];

function saveTrainingConducted() {
	event.preventDefault();
	trainingConducted.push(constructTrainingConducted());
	console.log(trainingConducted);
	showAlert("Saved Training Conducted");
}

var trainingAttended = [];

function saveTrainingAttended() {
	event.preventDefault();
	trainingAttended.push(constructTrainingAttended());
	console.log(trainingAttended);
	showAlert("Saved Training Attended");
}

var OEMMeet = [];


function saveOEMMeet() {
	event.preventDefault();
	OEMMeet.push(constructOEMMeet());
	console.log(OEMMeet);
	showAlert("Saved OEM Meet");
}

var partnership = [];

function savePartnership() {
	event.preventDefault();
	partnership.push(constructPartnership());
	console.log(partnership);
	showAlert("Saved Partnership");
}

$(document).ready(function() {

	$("#search-form").submit(function(event) {

		// stop submit the form, we will post it manually.
		event.preventDefault();

		fire_ajax_submit();

	});

});

function submitMessage() {

	// stop submit the form, we will post it manually.
	event.preventDefault();

	showAlert("modified post");

	var data = constructMessage();

	sendToApi(data);

}

function constructMessage() {

	var data = {};

	data["team"] = $("#team").val();
	
	data["date"] = $("#datepicker").val().replace("/", "-");;

	var catgegoryData = constructCategory();

	data["category"] = catgegoryData;

	return data;

}

function constructCategory() {

	var categorydata = {};

	categorydata["highlights"] = highlights;

	categorydata["solutionSupport"] = solutionSupport;
	categorydata["proactiveEngagement"] = proactiveEngagement;
	categorydata["deliverySupport"] = deliverySupport;
	categorydata["labActivities"] = labActivity;
	categorydata["poC"] = poC;
	categorydata["customerVisit"] = customerVisit;
	categorydata["internalActivities"] = internalActivities;
	categorydata["certification"] = certification;
	categorydata["trainingConducted"] = trainingConducted;
	categorydata["trainingAttended"] = trainingAttended;
	categorydata["oemmeet"] = OEMMeet;
	categorydata["partnership"] = partnership;
	console.log(categorydata);
	return categorydata;

}

function constructHighlights() {

	var data = {};

	
	data["highlights"] = $("#highlights").val();
	//	$("#highlights").val('');
	
	resetHighlights();

	return data;

}

function constructSS() {

	var data = {};

	data["customer"] = $("#SScustomer").val();

	data["ownedBy"] = $("#SSownedBy").val();

	data["bidOwner"] = $("#SSbidOwner").val();

	data["itis"] = $("#SSITis").val();

	data["geo"] = $("#SSgeo").val();

	data["industry"] = $("#SSindustry").val();

	data["isuowner"] = $("#SSISUOwner").val();

	data["action"] = $("#SSaction").val();
	
	resetSS();

	return data;

}

function constructDS() {

	var data = {};

	data["customer"] = $("#DScustomer").val();

	data["ownedBy"] = $("#DSownedBy").val();

	data["bidOwner"] = $("#DSbidOwner").val();

	data["itis"] = $("#DSITis").val();

	data["geo"] = $("#DSgeo").val();

	data["industry"] = $("#DSindustry").val();

	data["isuowner"] = $("#DSISUOwner").val();

	data["action"] = $("#DSaction").val();
	
	resetDS();

	return data;
}

function constructPE() {

	var data = {};

	data["customer"] = $("#PEcustomer").val();

	data["ownedBy"] = $("#PEownedBy").val();

	data["bidOwner"] = $("#PEbidOwner").val();

	data["itis"] = $("#PEITis").val();

	data["geo"] = $("#PEgeo").val();

	data["industry"] = $("#PEindustry").val();

	data["isuowner"] = $("#PEISUOwner").val();

	data["action"] = $("#PEaction").val();
	
	resetPE();

	return data;

}

function constructLabActivity() {

	var data = {};

	data["activityName"] = $("#labActivityName").val();

	data["activityBy"] = $("#labWorkedBy").val();
	
	resetLabActivity();

	return data;

}

function constructPOC() {
	var data = {};

	data["activityName"] = $("#poc").val();

	data["activityBy"] = $("#POCOwner").val();
	
	resetPOC();

	return data;

}

function constructCustomerVisited() {
	var data = {};

	data["customerVisited"] = $("#customerVisited").val();
	
	resetCustomerVisited();

	return data;

}

function constructInternalActivities() {
	var data = {};

	data["activityName"] = $("#internalActivity").val();

	data["activityBy"] = $("#intActOwner").val();
	
	resetInternalActivities();

	return data;

}

function constructCertification() {
	var data = {};

	data["activityName"] = $("#certName").val();

	data["activityBy"] = $("#certBy").val();
	
	resetCertification();

	return data;

}

function constructTrainingConducted() {
	var data = {};

	data["activityName"] = $("#trainingCond").val();

	data["activityBy"] = $("#traningCondBy").val();
	resetTrainingConducted();

	return data;

}

function constructTrainingAttended() {
	var data = {};

	data["activityName"] = $("#trainingAtt").val();

	data["activityBy"] = $("#trainingAttBy").val();
	resetTrainingAttended();

	return data;

}

function constructOEMMeet() {
	var data = {};

	data["activityName"] = $("#OEMName").val();

	data["activityBy"] = $("#OEMAttBy").val();
	resetOEMMeet();

	return data;

}

function constructPartnership() {
	var data = {};

	data["activityName"] = $("#venderBy").val();

	data["activityBy"] = $("#partnerAttBy").val();
	resetPartnership();

	return data;

}

function resetHighlights() {

	$("#highlights").val('');

}

function resetSS() {

	$("#SScustomer").val('');

	$("#SSownedBy").val('');

	$("#SSbidOwner").val('');

	$("#SSITis").val('');

	$("#SSgeo").val('');

	$("#SSindustry").val('');

	$("#SSISUOwner").val('');

	$("#SSaction").val('');

}

function resetDS() {

	$("#DScustomer").val('');

	$("#DSownedBy").val('');

	$("#DSbidOwner").val('');

	$("#DSITis").val('');

	$("#DSgeo").val('');

	$("#DSindustry").val('');

	$("#DSISUOwner").val('');

	$("#DSaction").val('');

}

function resetPE() {

	$("#PEcustomer").val('');

	$("#PEownedBy").val('');

	$("#PEbidOwner").val('');

	$("#PEITis").val('');

	$("#PEgeo").val('');

	$("#PEindustry").val('');

	$("#PEISUOwner").val('');

	$("#PEaction").val('');

}

function resetLabActivity() {

	$("#labActivityName").val('');

	$("#labWorkedBy").val('');

}

function resetPOC() {
	$("#poc").val('');

	$("#POCOwner").val('');

}

function resetCustomerVisited() {

	$("#customerVisited").val('');

}

function resetInternalActivities() {
	$("#internalActivity").val('');

	$("#intActOwner").val('');

}

function resetCertification() {
	$("#certName").val('');

	$("#certBy").val('');

}

function resetTrainingConducted() {
	$("#trainingCond").val('');

	$("#traningCondBy").val('');

}

function resetTrainingAttended() {
	$("#trainingAtt").val('');

	$("#trainingAttBy").val('');

}

function resetOEMMeet() {
	$("#OEMName").val('');

	$("#OEMAttBy").val('');

}

function resetPartnership() {
	$("#venderBy").val('');

	$("#partnerAttBy").val('');

}

function sendToApi(data) {

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/submit",
		data : JSON.stringify(data),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			console.log("SUCCESS : ", data);
			
			highlights = [];
			solutionSupport = [];
			proactiveEngagement = [];
			deliverySupport = [];
			labActivity = [];
			poC = [];
			customerVisit = [];
			internalActivities = [];
			certification = [];
			trainingConducted = [];
			trainingAttended = [];
			partnership = [];
			OEMMeet = [];

		},
		error : function(e) {

			console.log("ERROR : ", e);

		}

	});

}

$("#target").click(function() {
	showAlert("Handler for .click() called.");
});

$("#submitButton").click(function() {
	showAlert("Trying to submit");
});

function submit() {
	showAlert("Trying to submit");
}

function fire_ajax_submit() {

	showAlert("Data Submitted");

	var data = {}
	data["username"] = $("#username").val();

	data["week"] = $("#week").val();

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/submit",
		data : JSON.stringify(data),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			console.log("SUCCESS : ", data);

		},
		error : function(e) {

			console.log("ERROR : ", e);

		}

	});

	/*
	 * var search = {} search["username"] = $("#username").val();
	 * //search["email"] = $("#email").val();
	 * 
	 * $("#btn-search").prop("disabled", true);
	 * 
	 * $.ajax({ type: "POST", contentType: "application/json", url:
	 * "/api/search", data: JSON.stringify(search), dataType: 'json', cache:
	 * false, timeout: 600000, success: function (data) {
	 * 
	 * var json = "<h4>Ajax Response</h4><pre>" + JSON.stringify(data,
	 * null, 4) + "</pre>"; $('#feedback').html(json);
	 * 
	 * console.log("SUCCESS : ", data); $("#btn-search").prop("disabled",
	 * false); }, error: function (e) {
	 * 
	 * var json = "<h4>Ajax Response</h4><pre>" + e.responseText + "</pre>";
	 * $('#feedback').html(json);
	 * 
	 * console.log("ERROR : ", e); $("#btn-search").prop("disabled", false); }
	 * });
	 */
}