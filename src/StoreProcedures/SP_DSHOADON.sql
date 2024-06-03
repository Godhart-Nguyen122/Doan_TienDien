create proc [dbo].[SP_DSHOADON] (@tt int, @username varchar(50))
as
begin
	if(@tt <> 2)
		begin
			select i.ID, i.Invoice_Date, i.Level, ed.Current_Num,i.ID_Staff_Write, ed.ID_Staff_Input, piv.Date
			from CUSTOMERS cus inner join E_METERS e on cus.ID = e.ID_Customer inner join E_METER_DETAILS ed 
			on e.ID_E_METER = ed.ID_E_METER inner join INVOICES i on ed.ID = i.ID_Details inner join PAID_INVOICES piv
			on i.ID = piv.ID_INVOICES
			where cus.Account_Customer = @username and i.Invoice_Status = @tt
		end	
	else 
		begin
			select i.ID, i.Invoice_Date, i.Level, ed.Current_Num,i.ID_Staff_Write, ed.ID_Staff_Input, piv.Date
			from CUSTOMERS cus inner join E_METERS e on cus.ID = e.ID_Customer inner join E_METER_DETAILS ed 
			on e.ID_E_METER = ed.ID_E_METER inner join INVOICES i on ed.ID = i.ID_Details inner join PAID_INVOICES piv
			on i.ID = piv.ID_INVOICES
			where cus.Account_Customer = @username
		end
end