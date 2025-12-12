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
