CREATE PROCEDURE [dbo].[SP_DSHOADON]
    @tt INT,
    @username VARCHAR(50)
AS
BEGIN
    IF (@tt = 1)
    BEGIN
        SELECT 
            i.ID, 
            i.Invoice_Date, 
            i.Level, 
            (i.End_Num - i.Start_Num) AS KWH, 
            i.ID_Staff_Write, 
            i.Total_Price
        INTO #temp
        FROM 
            CUSTOMERS cus 
            INNER JOIN E_METERS e ON cus.ID = e.ID_Customer 
            INNER JOIN E_METER_DETAILS ed ON e.ID_E_METER = ed.ID_E_METER 
            INNER JOIN INVOICES i ON ed.ID = i.ID_Details
        WHERE 
            cus.Account_Customer = @username 
            AND i.Invoice_Status = @tt;

        --- Get staff names ---
        SELECT  
            t.ID, 
            t.Invoice_Date, 
            t.KWH, 
            t.Level, 
            t.Total_Price, 
            (p.Firstname + ' ' + p.Middlename + ' ' + p.Lastname) AS FNAME
        FROM 
            #temp t 
            INNER JOIN STAFFS s ON t.ID_Staff_Write = s.ID 
            INNER JOIN ACCOUNTS a ON s.Account_Staffs = a.Account_Username 
            INNER JOIN PERSON_INFOS p ON a.CCCD = p.CCCD;
    END
    ELSE IF (@tt = 0)
    BEGIN
        SELECT 
            i.ID, 
            i.Invoice_Date, 
            i.Level, 
            (i.End_Num - i.Start_Num) AS KWH, 
            i.ID_Staff_Write, 
            i.Total_Price
        INTO #temp
        FROM 
            CUSTOMERS cus 
            INNER JOIN E_METERS e ON cus.ID = e.ID_Customer 
            INNER JOIN E_METER_DETAILS ed ON e.ID_E_METER = ed.ID_E_METER 
            INNER JOIN INVOICES i ON ed.ID = i.ID_Details
        WHERE 
            cus.Account_Customer = @username 
            AND i.Invoice_Status = @tt;

        --- Get staff names ---
        SELECT  
            t.ID, 
            t.Invoice_Date, 
            t.KWH, 
            t.Level, 
            t.Total_Price, 
            (p.Firstname + ' ' + p.Middlename + ' ' + p.Lastname) AS FNAME
        FROM 
            #temp t 
            INNER JOIN STAFFS s ON t.ID_Staff_Write = s.ID 
            INNER JOIN ACCOUNTS a ON s.Account_Staffs = a.Account_Username 
            INNER JOIN PERSON_INFOS p ON a.CCCD = p.CCCD;
    END
    ELSE IF (@tt = 2)
    BEGIN
        SELECT 
            i.ID, 
            i.Invoice_Date, 
            i.Level, 
            (i.End_Num - i.Start_Num) AS KWH, 
            i.ID_Staff_Write, 
            i.Total_Price
        INTO #temp
        FROM 
            CUSTOMERS cus 
            INNER JOIN E_METERS e ON cus.ID = e.ID_Customer 
            INNER JOIN E_METER_DETAILS ed ON e.ID_E_METER = ed.ID_E_METER 
            INNER JOIN INVOICES i ON ed.ID = i.ID_Details
        WHERE 
            cus.Account_Customer = @username;

        --- Get staff names ---
        SELECT  
            t.ID, 
            t.Invoice_Date, 
            t.KWH, 
            t.Level, 
            t.Total_Price, 
            (p.Firstname + ' ' + p.Middlename + ' ' + p.Lastname) AS FNAME
        FROM 
            #temp t 
            INNER JOIN STAFFS s ON t.ID_Staff_Write = s.ID 
            INNER JOIN ACCOUNTS a ON s.Account_Staffs = a.Account_Username 
            INNER JOIN PERSON_INFOS p ON a.CCCD = p.CCCD;
    END
END
