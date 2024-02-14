-- 코드를 입력하세요
SELECT AP.APNT_NO, PA.PT_NAME, PA.PT_NO, AP.MCDP_CD, DOC.DR_NAME, AP.APNT_YMD
FROM APPOINTMENT AS AP
JOIN PATIENT AS PA ON AP.PT_NO = PA.PT_NO
JOIN DOCTOR AS DOC ON AP.MDDR_ID = DOC.DR_ID
WHERE 
    AP.MCDP_CD = 'CS'
    AND AP.APNT_CNCL_YN = 'N' 
    AND DATE(AP.APNT_YMD) LIKE '2022-04-13%'
ORDER BY 6