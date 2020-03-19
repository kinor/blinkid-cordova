package com.phonegap.plugins.microblink.recognizers.serialization;

import com.microblink.entities.recognizers.Recognizer;
import com.phonegap.plugins.microblink.recognizers.RecognizerSerialization;

import org.json.JSONException;
import org.json.JSONObject;

public final class BlinkIdCombinedRecognizerSerialization implements RecognizerSerialization {

    @Override
    public Recognizer<?> createRecognizer(JSONObject jsonRecognizer) {
        com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer recognizer = new com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer();
        recognizer.setAllowBlurFilter(jsonRecognizer.optBoolean("allowBlurFilter", true));
        recognizer.setAllowUnparsedMrzResults(jsonRecognizer.optBoolean("allowUnparsedMrzResults", false));
        recognizer.setAllowUnverifiedMrzResults(jsonRecognizer.optBoolean("allowUnverifiedMrzResults", true));
        recognizer.setFaceImageDpi(jsonRecognizer.optInt("faceImageDpi", 250));
        recognizer.setFullDocumentImageDpi(jsonRecognizer.optInt("fullDocumentImageDpi", 250));
        recognizer.setFullDocumentImageExtensionFactors(BlinkIDSerializationUtils.deserializeExtensionFactors(jsonRecognizer.optJSONObject("fullDocumentImageExtensionFactors")));
        recognizer.setReturnFaceImage(jsonRecognizer.optBoolean("returnFaceImage", false));
        recognizer.setReturnFullDocumentImage(jsonRecognizer.optBoolean("returnFullDocumentImage", false));
        recognizer.setSignResult(jsonRecognizer.optBoolean("signResult", false));
        return recognizer;
    }

    @Override
    public JSONObject serializeResult(Recognizer<?> recognizer) {
        com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer.Result result = ((com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer)recognizer).getResult();
        JSONObject jsonResult = new JSONObject();
        try {
            SerializationUtils.addCommonResultData(jsonResult, result);
            jsonResult.put("additionalAddressInformation", result.getAdditionalAddressInformation());
            jsonResult.put("additionalNameInformation", result.getAdditionalNameInformation());
            jsonResult.put("address", result.getAddress());
            jsonResult.put("conditions", result.getConditions());
            jsonResult.put("dateOfBirth", SerializationUtils.serializeDate(result.getDateOfBirth()));
            jsonResult.put("dateOfExpiry", SerializationUtils.serializeDate(result.getDateOfExpiry()));
            jsonResult.put("dateOfExpiryPermanent", result.isDateOfExpiryPermanent());
            jsonResult.put("dateOfIssue", SerializationUtils.serializeDate(result.getDateOfIssue()));
            jsonResult.put("digitalSignature", SerializationUtils.encodeByteArrayToBase64(result.getDigitalSignature()));
            jsonResult.put("digitalSignatureVersion", (int)result.getDigitalSignatureVersion());
            jsonResult.put("documentAdditionalNumber", result.getDocumentAdditionalNumber());
            jsonResult.put("documentDataMatch", SerializationUtils.serializeEnum(result.getDocumentDataMatch()));
            jsonResult.put("documentNumber", result.getDocumentNumber());
            jsonResult.put("driverLicenseDetailedInfo", BlinkIDSerializationUtils.serializeDriverLicenseDetailedInfo(result.getDriverLicenseDetailedInfo()));
            jsonResult.put("employer", result.getEmployer());
            jsonResult.put("faceImage", SerializationUtils.encodeImageBase64(result.getFaceImage()));
            jsonResult.put("firstName", result.getFirstName());
            jsonResult.put("fullDocumentBackImage", SerializationUtils.encodeImageBase64(result.getFullDocumentBackImage()));
            jsonResult.put("fullDocumentFrontImage", SerializationUtils.encodeImageBase64(result.getFullDocumentFrontImage()));
            jsonResult.put("fullName", result.getFullName());
            jsonResult.put("issuingAuthority", result.getIssuingAuthority());
            jsonResult.put("lastName", result.getLastName());
            jsonResult.put("localizedName", result.getLocalizedName());
            jsonResult.put("maritalStatus", result.getMaritalStatus());
            jsonResult.put("mrzResult", BlinkIDSerializationUtils.serializeMrzResult(result.getMrzResult()));
            jsonResult.put("nationality", result.getNationality());
            jsonResult.put("personalIdNumber", result.getPersonalIdNumber());
            jsonResult.put("placeOfBirth", result.getPlaceOfBirth());
            jsonResult.put("profession", result.getProfession());
            jsonResult.put("race", result.getRace());
            jsonResult.put("religion", result.getReligion());
            jsonResult.put("residentialStatus", result.getResidentialStatus());
            jsonResult.put("scanningFirstSideDone", result.isScanningFirstSideDone());
            jsonResult.put("sex", result.getSex());
        } catch (JSONException e) {
            // see https://developer.android.com/reference/org/json/JSONException
            throw new RuntimeException(e);
        }
        return jsonResult;
    }

    @Override
    public String getJsonName() {
        return "BlinkIdCombinedRecognizer";
    }

    @Override
    public Class<?> getRecognizerClass() {
        return com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer.class;
    }
}