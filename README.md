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

گزارش اصلاح معماری سیستم رزرو هتل بر اساس اصول SOLID

این گزارش توضیح می‌دهد که در گام سوم، برای رفع نقض‌های اصول شی‌گرایی در سیستم، چه اقداماتی انجام شد و در هر بخش کدام اصل SOLID اصلاح گردید.

 اصلاح اصل SRP – Single Responsibility Principle
 مشکل:

کلاس ReservationService چندین وظیفه را با هم انجام می‌داد:

اعمال تخفیف
مدیریت پرداخت
چاپ فاکتور
ارسال پیام به مشتری

✔ اقدام اصلاحی:

سیستم به چند بخش مستقل تقسیم شد:
کلاس PaymentProcessor مسئول پرداخت
کلاس‌های EmailSender و SmsSender مسئول ارسال پیام
ReservationService فقط کار رزرو را مدیریت می‌کند

 نتیجه:

هر کلاس تنها یک نقش مشخص دارد → کد خواناتر، تست‌پذیرتر و توسعه‌پذیرتر شد.

 اصلاح اصل OCP – Open/Closed Principle
 مشکل:

در ReservationService از چندین switch-case برای:

نوع پرداخت

نوع پیام‌رسان
استفاده شده بود.
افزودن یک روش جدید باعث تغییر کدهای موجود می‌شد.

✔ اقدام اصلاحی:

شناسه‌های سخت‌کد حذف شد
جایگزین شدند با Interface‌ها
پیاده‌سازی‌ها در کلاس‌های مستقل انجام شدند

 نتیجه:

برای افزودن قابلیت جدید مثل:

پرداخت حضوری

ارسال SMS
فقط کلاس جدید اضافه می‌کنیم و هیچ خطی از کد قبلی را تغییر نمی‌دهیم.

 اصلاح اصل LSP – Liskov Substitution Principle
 مشکل:

Interface پیام‌رسان فقط متد sendEmail داشت.
کلاس‌های جدید مانند SmsSender مجبور بودند متدی را پیاده‌سازی کنند که مخصوص ایمیل است → نقض LSP.

✔ اقدام اصلاحی:

تعریف یک Interface جدید:

public interface MessageSender {
    void send(String to, String message);
}


هر پیام‌رسان می‌تواند نسخه مناسب خود را ارائه دهد:

EmailSender → پیاده‌سازی ایمیل

SmsSender → پیاده‌سازی پیامک

 نتیجه:

هر زیرکلاس می‌تواند بدون ایجاد رفتار نادرست جایگزین والد شود.

4 اصلاح اصل ISP – Interface Segregation Principle
 مشکل:

MessageSender فقط متد sendEmail داشت و همه کلاس‌ها مجبور بودند آن را پیاده‌سازی کنند.

✔ اقدام اصلاحی:

بازطراحی Interface:

void send(String to, String message);


حالا هر پیام‌رسان فقط همان متدی را دارد که واقعاً نیاز دارد.

 نتیجه:

فشار غیرضروری روی کلاس‌ها حذف شد؛ Interface کوچک، دقیق و تخصصی شد.

 اصلاح اصل DIP – Dependency Inversion Principle
 مشکل:

ReservationService مستقیماً به EmailSender وابسته بود:

EmailSender emailSender = new EmailSender();


این یعنی:

وابستگی به پیاده‌سازی

عدم امکان تست‌پذیری

هر نوع پیام‌رسان جدید نیازمند تغییر در ReservationService بود

✔ اقدام اصلاحی:

ReservationService فقط به Interface وابسته شد:

MessageSender notifier;


و نوع پیام‌رسان از بیرون تزریق شد (Dependency Injection).

 نتیجه:

ReservationService از جزئیات ارسال پیام بی‌نیاز است و تنها به abstraction وابسته است.

 اصلاح اصل PLK – Principle of Least Knowledge
 مشکل:

ReservationService بیش از اندازه درباره جزئیات داخلی کلاس‌ها اطلاع داشت:

res.customer.email  
res.customer.city  
res.room.price  

 اقدام اصلاحی:

متدهای مخصوص داده‌خوانی ایجاد شد

مقداردهی و قیمت‌گذاری در کلاس‌های مربوطه متمرکز شد

وابستگی به ساختار داخلی کلاس‌ها کاهش یافت

 نتیجه:

کلاس‌ها کمتر به جزئیات یکدیگر دسترسی دارند و وابستگی کاهش پیدا کرد.

 اصلاح اصل CRP – Common Reuse Principle
 مشکل:

MessageSender قابل استفاده مجدد نبود چون فقط ایمیل را پشتیبانی می‌کرد.

 اقدام اصلاحی:

یک Interface عمومی ایجاد شد.
هر پیام‌رسان (Email، SMS، شبکه اجتماعی، واتساپ، …) می‌تواند بدون تغییر در کدهای قبلی اضافه شود.

