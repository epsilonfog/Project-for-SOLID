# Project-for-SOLID

This is the frist homwork for Object oriented design



<table border="1" cellpadding="6" cellspacing="0">

<thead>

<tr>

&nbsp;   <th>ردیف</th>

&nbsp;   <th>کلاس تغییر یافته (ارسال پیام)</th>

&nbsp;   <th>توضیح کوتاه درباره تغییر (افزودن روش ارسال پیام)</th>

&nbsp;   <th>کلاس تغییر یافته (پرداخت)</th>

&nbsp;   <th>توضیح کوتاه درباره تغییر (افزودن روش پرداخت)</th>

</tr>

</thead>

<tbody>

<tr>

&nbsp;   <td>1</td>

&nbsp;   <td>MessageSender</td>

&nbsp;   <td>افزودن قابلیت جدید برای ارسال پیامک از طریق ایجاد کلاس SmsSender که از اینترفیس MessageSender پیروی می‌کند</td>

&nbsp;   <td>PaymentProcessor</td>

&nbsp;   <td>افزودن تابع جدید به نام payOnSite برای پشتیبانی از پرداخت حضوری</td>

</tr>

<tr>

&nbsp;   <td>2</td>

&nbsp;   <td>EmailSender</td>

&nbsp;   <td>بدون تغییر — الگوی قبلی برقرار ماند و صرفاً کلاس جدید برای SMS اضافه شد</td>

&nbsp;   <td>ReservationService</td>

&nbsp;   <td>اضافه کردن case جدید برای PaymentMethods.ONSITE در ساختار switch مربوط به پرداخت</td>

</tr>

<tr>

&nbsp;   <td>3</td>

&nbsp;   <td>SmsSender (کلاس جدید)</td>

&nbsp;   <td>ایجاد یک کلاس جدید برای ارسال پیامک مطابق ساختار EmailSender</td>

&nbsp;   <td>PaymentMethods</td>

&nbsp;   <td>افزودن مقدار جدید enum به نام ONSITE جهت معرفی روش پرداخت حضوری</td>

</tr>

<tr>

&nbsp;   <td>4</td>

&nbsp;   <td>ReservationService</td>

&nbsp;   <td>افزودن case جدید برای ارسال پیامک (Notifier.SMS) و استفاده از SmsSender</td>

&nbsp;   <td>—</td>

&nbsp;   <td>—</td>

</tr>

</tbody>

</table>



