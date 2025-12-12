# Project-for-SOLID

This is the frist homwork for Object oriented design

<table dir="rtl">
  <thead>
    <tr>
      <th>ردیف</th>
      <th>کلاس تغییر یافته (ارسال پیام)</th>
      <th>توضیح کوتاه درباره تغییر</th>
      <th>کلاس تغییر یافته (پرداخت)</th>
      <th>توضیح کوتاه درباره تغییر</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>MessageSender</td>
      <td>افزودن قابلیت ارسال پیامک با ایجاد SmsSender</td>
      <td>PaymentProcessor</td>
      <td>افزودن payOnSite جهت پرداخت حضوری</td>
    </tr>
    <tr>
      <td>2</td>
      <td>EmailSender</td>
      <td>بدون تغییر، فقط کلاس SMS اضافه شد</td>
      <td>ReservationService</td>
      <td>افزودن case جدید برای ONSITE</td>
    </tr>
    <tr>
      <td>3</td>
      <td>SmsSender</td>
      <td>ایجاد کلاس جدید مشابه EmailSender</td>
      <td>PaymentMethods</td>
      <td>افزودن مقدار جدید ONSITE</td>
    </tr>
    <tr>
      <td>4</td>
      <td>ReservationService</td>
      <td>افزودن case برای Notifier.SMS</td>
      <td>—</td>
      <td>—</td>
    </tr>
  </tbody>
</table>


<table border="1" cellpadding="6" cellspacing="0">
    <thead>
        <tr>
            <th>اصل</th>
            <th>رعایت</th>
            <th>نقض</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>SRP</td>
            <td>Class Room</td>
            <td>ReservationService</td>
        </tr>
        <tr>
            <td>OCP</td>
            <td>افزودن LuxuryRoom بدون تغییر Room</td>
            <td>switch در ReservationService</td>
        </tr>
        <tr>
            <td>LSP</td>
            <td>استفاده از LuxuryRoom</td>
            <td>نامناسب بودن MessageSender برای کلاس‌های جدید</td>
        </tr>
        <tr>
            <td>ISP</td>
            <td>توابع جدا در PaymentProcessor</td>
            <td>وجود فقط sendEmail در MessageSender</td>
        </tr>
        <tr>
            <td>DIP</td>
            <td>وجود Interface برای MessageSender</td>
            <td>وابستگی ReservationService به EmailSender</td>
        </tr>
        <tr>
            <td>PLK</td>
            <td>ساده بودن PaymentProcessor</td>
            <td>دسترسی عمیق به فیلدهای Customer و Room</td>
        </tr>
        <tr>
            <td>CRP</td>
            <td>قابلیت استفاده مشترک Room و Customer</td>
            <td>عدم قابلیت استفاده مجدد MessageSender</td>
        </tr>
    </tbody>
</table>
