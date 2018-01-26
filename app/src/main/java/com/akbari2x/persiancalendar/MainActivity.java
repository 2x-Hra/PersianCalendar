package com.akbari2x.persiancalendar;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    String jmonths[]={"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"};

    String months[] = {"January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
    };

    String aMonths[] = {"محرّم", "صفر", "ربیع الاوّل",
            "ربیع الثانی", "جمادی الاولی", "جمادی الاخری", "رجب",
            "شعبان", "رمضان", "شوّال", "ذو القعده", "ذو الحجّه"};


    String farvardin[] = {"آغاز عید نوروز", "عید نوروز ; هجوم به مدرسه فیضیه قم (1342 ه.ش) ; آغاز عملیات فتح المبین (1361 ه.ش)","عید نوروز","عید نوروز","",
            " روز امید  ٍ روز شادباش نویسی","روز هنر های نمایشی","","","همه پرسی  تغییر نظام شاهنشاهی به جمهوری اسلامی ایران (1358 ه.ش) ; جشن آبانگاه ",
            "","روز جمهوری اسلامی ایران","روز طبیعت  ;  جشن سیزده بدر","","روز ذخایر ژنتیکی و زیستی ","","سروش روز  ٍ جشن سروشگان","روز سلامتی","شهادت آیت الله سید محمد باقر صدر و خواهر ایشان بنت الهدی (1359 ه.ش) ; فرورین روز ٍ جشن فروردینگان","روز ملی فناوری هسته ای  ;  روز هنر انقلاب اسلامی  ;  شهادت سید مرتضی آوینی (1372 ه.ش)  ;  قطع مناسبات سیاسی ایران و آمریکا (1359 ه.ش) "
            ,"شهادت امیر سپهبد علی صیاد شیرازی (1378 ه.ش)  ;  سالروز افتتاح حساب شماره 100 و تاسیس بنیاد مسکن  انقلاب اسلامی (1358 ه.ش) ","ولادت حضرت امام علی علیه السلام (23 سال قبل از هجرت)",
            "","","روز بزرگداشت عطار نیشابوری","","","","روز ارتش جمهوری اسلامی و نیروی زمینی","",""};

    boolean farvardin2[] = {true,true,true,true,false,false,false,false,false,false,true,true,true,false,false,false,false,true,false,false,false,true,false,false,true,false,false,false,false,false,false};

    String ordibehesht[] = {"روز بزگداشت سعدی", "تاسیس سپاه پاسداران انقلاب اسلامی (1358 ه.ش)  ;  اعلام انقلاب فرهنگی (1359 ه.ش)   ; روز زمین پاک   ; جشن گیاه آوری",
            "روز بزرگداشت شیخ بهایی  ;  اردیبهشت روز ٍ جشن اردیبهشتگان", "", "مبعث حضرت رسول اکرم(ص) (13 سال قبل از هجرت)  ; شکست حمله نظامی آمریکا به ایران در طبس (1359 ه.ش)",
            "", "روز ایمنی حمل و نقل ", "", "روز شوراها", "روز ملی خلیج فارس  ;  آغاز عملیات بیت المقدس (1361 ه.ش )  ; جشن چهلم نوروز",
            "", "شهادت استاد مرتضی مطهری (1358 ه.ش)  ; روز معلم  ; روز جهانی مستضفان ", "", "", "روز بزرگداشت شیخ صدوق  ; جشن بهاربٌد ، جشن میانه بهار / روز پیام آوری زرتشت",
            "", "", "روز بیماری های خاص و صعب العلاج", "روز بزرگداشت شیخ کلینی  ; روز اسناد ملی و میراث مکتوب", "", "", "ولادت حضرت قائم (255 ه.ق) ", "",
            "لغو امتیاز تنباکو به فتوای آیت الله میرزا حسن شیرازی (1270 ه.ش)", "روز پاسدات زبان فارسی و بزرگداشت حکیم ابوالقاسم فردوسی ",
            "", "روز ارتباطات و روابط عمومی ", "روز بزرگداشت حکیم عمر خیام", "","روز ملی جمعیت", "روز اهدای عضو ، اهدای زندگی"};

    boolean ordibehesht2[] = {true,false,false,false,true,false,false,true,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,false};
    String khordad[] = {"روز بهره وری و بهینه سازی مصرف  ;  روز بزرگداشت ملاصدار (صدرالمتالهین) ; ارغاسوان ، جشن گرما",
            "", "فتح خرمشهر در عملیات بیت المقدس (1361 ه.ش) ", "روز مقاومت ، ایثار و پیروزی  ; روز دزفول  ; روز مقاومت و پایداری ",
            "روز نسیم مهر ( روز حمایت از خانواده زندانیان)", "خرداد روز ، جشن خردادگان", "افتتاح اولین دوره مجلس شورای اسلامی(1359 ه.ش)",
            "", "", "", "", "", "", "رحلت امام خمینی (1368 ه.ش)  ; انتخاب آیت الله خامنهای به رهبری (1368 ه.ش)", "قیام خونین 15 خرداد ( 1342 ه.ش)  ;  زندانی شدن امام خمینی (1342 ه.ش)",
            "", "", "", "", "شهدت آیت الله سعیدی (1349 ه.ش)", "", "", "", "", "روز گل و گیاه", "شهادت حضرت علی علیه السلام (40 ه.ق)  ; شهدت سربازان دلیر اسلام: بخارایی ، امانی ، صفار هندیو نیک نژاد (1344 ه.ش)",
            "روز جهاد کشاورزی (تشکیل جهاد سازندگی ، 1358 ه.ش) ", "", "درگذشت دکتر علی شریعتی (1356 ه.ش)","شهادت زائران حرم رضوی(ع) (عاشورای 1373 ه.ش)", "شهادت دکتر مصطفی چمران (1360 ه.ش)  ; روز بسیج استادن "};

    boolean khordad2[] = {false, false, false, false, true, false, false, false, false, false, false, true, false, true, true, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false};

    String tir[] = {"روز تبلیغ و اطلاع رسانی دینی ; روز اصناف  ; جشن آب پاشونک، جشن آغاز تابستان",
            "", "", "", "عید سعید فطر", "تعطیل به مناسبت عید سعید فطر  ; جشن نیلوفر", "شهادت آیت الله دکتر بهشتی و 72 تن از یاران (1360 ه.ش)  ; روز قوه قضاییه",
            "روز مبارزه با سلاح های شیمیایی و میکروبی", "", "روز صنعت و معدن  ; روز فرهنگ پهلوانی و ورزش زورخانه ای  ; روز آزادسازی شهر مهران",
            "شهادت آیت الله صدوقی (1361 ه.ش)", "حمله ناوگان آمریکایی به هواپیمای مسافربری ایران (1367 ه.ش)  ; روز افشای حقوق بشر آمریکایی  ; روز بزرگداشت علامه امینی (1349 ه.ش)",
            "تیر روز ، جشن تیرگان", "روز قلم", "جشن خام خواری", "روز مالیات", "", "روز ادبیات کودک و نوجوان ", "", "", "روز عفاف  حجاب  ; کشف توطئه کودتای آمریکایی در پایگاه هوایی شهید نوژه(1359 ه.ش)  ; حمله به مسجد گوهرشاد و کشتار مردم(1314 ه.ش)",
            "", "روز گفت و گو و تعامل سازنده با جهان  ; گشایش نخستین مجلس خبرگان رهبری (1362ه.ش)", "", "روز بهزیستی و تامین اجتماعی", "سالروز تاسیس نهاد شورای نگهبان",
            "اعلام پذیرش قطعنامه 598 شورای امنیت از سوی ایران (1367ه.ش)", "روز  تجلیل از امام زادگان و بقاع متبرکه",
            "شهادت حضرت امام جعفر صادق علیه السلام (148ه.ق)  ; روز بزرگداشت حضرت احمد بن موسی شاهچراغ علیه السلام","", ""};

    boolean tir2[] = {false, true, false, false, true, true, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, true, true, false};

    String mordad[] = {"", "", "", "", "سالروز عملیات مرصاد (1367ه.ش)", "روزکارآفرینی و آموزش های فنی و حرفه ای", "مرداد روز ، جشن مردادگان",
            "روز بزرگداشت شیخ شهاب الدین سهروردی ", "روز اهدای خون", "جشن چله تابستان ", "شهادت آیت الله شیخ فضل الله نوری (1288ه.ش)", "", "",
            "صدور فرمان مشروطیت (1285ه.ش)  ; روز حقوق بشر اسلامی و کرامت انسانی", "جشن میانه تابستان ، گاهنبار میدیوشم", "تشکیل جهاد دانشگاهی (1359ه.ش)",
            "روز خبرنگار ", "جشن مَی خواره", "", "", "روز حمایت از صنایع کوچک", "روز تشکل ها و مشارکت های اجتماعی", "روز مقاومت اسلامی", "", "",
            "آغاز بازگشت آزادگان به میهن اسلامی (1369ه.ش)", "", "کودتای آمریکا برای بازگرداندن شاه (1332ه.ش)  ; گشایش مجلس خبرگان برای بررسی نهایی قانون اساسی جمهوری اسلامی ایران (1358ه.ش)",
            "","روز بزرگداشت علامه مجلسی", "روز صنعت دفاعی"};

    boolean mordad2[] = {false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false};

    String shahrivar[] = {"روز بزرگداشت ابوعلی سینا ; روز پزشک  ; فغدیه، جشن خنکی هوا", "آغاز هفته دولت  ; شهادت سید علی اندرزگو (1357ه.ش)",
            "جشن کشمین", "روز کارمند  ; شهریور روز  ; جشن شهریورگان", "روز بزرگداشت محمد بن زکریای رازی  ;  روز داروسازی  ; روز کشتی ", "", "",
            "روز مبارزه با تروریسم  ; خزان جشن", "", "عید سعید قربان  ; روز بانکداری اسلامی", "روز صنعت چاپ", "روز مبارزه با استعمار انگلیس (شهادت رییسعلی دلواری)  ; روز بهورز",
            "روز تعاون  ; روز بزرگداشت ابوریحان بیرونی", "شهادت آیت الله قدوسی و سرتیپ وحید دستجردی (1360 ه.ش)", "بازارجشن", "",
            "قیام 17 شهریور و کشتار جمعی از مردم به دست ماموران پهلوی (1357ه.ش)", "عید سعید غدیر خم (10ه.ق)", "وفات آیت الله سید محمود طالقانی (1358ه.ش)",
            "شهادت آیت الله مدنی (360ه.ش)", "روز سینما", "", "", "", "", "", "روز شعر و ادب فارسی  ; روز بزرگداشت استاد شهریار", "", "",
            "روز تجلیل از اسرا و مفقودان  ; روز گفت و گوی تمدن ها","آغاز جنگ تحمیلی (1359ه.ش)  ; آغاز هفته دفاع مقدس  ; جشن پایان تابستان"};

    boolean shahrivar2[] = {false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, true, false, false, false, false, false, true, false, false, false, false, false, false, true};

    String mehr[] = {"جشن میتراکانا / سال نو هخامنشی", "", "", "", "شکست حصر آبادان (1360ه.ش)", "", "روز آتش نشانی و ایمنی  ; روز بزرگداشت شمس", "تاسوعای حسینی  ; روز بزرگداشت مولوی",
            "عاشورای حسینی ", "", "", "آیین قالیشویان اردهال ، بازماندی از تیرگان", "هجرت امام خمینی از عراق به پاریس (1357ه.ش)  ; روز نیروی انتظامی ",
            "روز دامپزشکی", "روز روستا و عشایر", "مهر روز، جشن مهرگان", "", "", "", "روز بزرگداشت حافظ  ; روز اسکان معلولان و سالمندان", "رام روز،جشن رام روزی / جشن پیروزی کاوه و فریدون",
            "", "شهادت آیت الله اشرفی اصفهانی (1361ه.ش)", "روز ملی پارالمپیک  ; روز پیوند اولیا و مربیان  ; به آتش کشیدن مسجد جامع سشهر کرمان (1357ه.ش)", "روز بزرگداشت سلمان فارسی",
            "روز تربیت بدنی و ورزش", "", "", "روز صادرات", ""};

    boolean mehr2[] = {false, false, false, false, false, false, true, true, true, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, false};

    String aban[] = {"شهادت آیت الله حاج سید مصطفی خمینی (1356ه.ش)  ; روز آمار و برنامه ریزی", "", "", "اعتراض و افشاگری امام خمینی علیه پذیرش کاپیتولاسیون (1343ه.ش)", "", "", "",
            "شهادت محمد حسین فهمیده  ; روز نوجوان و بسیج دانش آموزی ", "", "شهادت آیت الله قاضی طباطبایی (1358ه.ش)  ; آبان روز ، جشن آبانگان", "", "",
            "تسخیر لانه جاسوسی آمریکا(1358ه.ش)  ; روز ملی مبارزه با استکبار جهانی  ; روز دانش آموز  ; تبغید امام خمینی از ایران به ترکیه (1343ه.ش)", "روز فرهنگ عمومی",
            "روز وقف  ; گاهنبار ایاثرم ، جشن میانه پاییز", "", "", "اربعین حسینی  ; روز کیفیت", "", "", "", "", "", "روز کتاب ، کتابخوانی و کتابدار  ; روز بزرگداشت آیت الله علامه سید محمد حسین طباطبایی (1360ه.ش)",
            "", "رحلت حضرت رسول اکرم (11ه.ق)  ; شهادت حضرت امام حسن مجتبی علیه السلام (50ه.ق)  ; آزاد سازی سوسنگرد", "", "شهادت حضرت امام رضا علیه السلام(203ه.ق)", "", ""};

    boolean aban2[] = {false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, true, true, false, false, false, false, false, false, true, false, true, false, false};

    String azar[] = {"آذرجشن", "", "", "", "تشکیل بسیج مستضعفان (1358ه.ش)", "شهادت حضرت امام حسن عسکری علیه السلام و آغاز امامت حضرت ولیعصر", "روز نیروی دریایی",
            "", "روز بزگداشت شیخ مفید  ; آذر روز ، جشن آذرگان", "شهادت آیت الله مدرس  ; روز مجلس ", "شهادت میرزا کوچک خان جنگلی", "روز قانون اساسی جمهوری اسلامی ایران",
            "روز بیمه", "", "میلاد حضرت رسول اکرم (53 سال قبل از هجرت)  ; میلاد حضرت امام جعفر صادق علیه اسلام (83ه.ق)", "روز دانشجو", "",
            "معرفی عراق به عنوان مسئول و آغازگر جنگ از سوی سازمان ملل (1370ه.ش)", "تشکیل شورای عالی انقلاب فرهنگی (1363ه.ش)", "شهادت آیت الله دستغیب (1360ه.ش)", "", "", "", "",
            "روز پژوهش  ; روز تجلیل از شهید تندگویان", "روز حمل و نقل و رانندگان", "شهادت آیت الله دکتر محمد مفتح (1358ه.ش)  ; روز وحدت حوزه و دانشگاه", "", "",
            "شب یلدا(چله)"};

    boolean azar2[] = {false, false, true, false, false, true, false, false, false, true, false, false, false, false, true, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false};

    String dey[] = {"روز میلاد خورشید،جشن خرم روز", "", "روز ثبت احوال", "", "روز ملی ایمنی در برابر زلزله و کاهش اثرات بلایای طبیعی", "",
            "تشکیل نهضت سوادآموزی (1358ه.ش) ; شهادت آیت الله حسین غفاری (1353 ه.ش)", "", "", "", "", "", "ابلاغ پیام تاریخی امام خمینی به گورباچف (1367ه.ش)",
            "سیرسور،جشن گیاه خواری", "جشن پیکر تراشی", "جشن درامزینان ، جشن درفشان", "اجرای طرح استعماری حذف حجاب (1314ه.ش)", "",
            "قیام خونین مرذم قم (1356ه.ش)", "شهادت امیرکبیر (1320ه.ش)", "", "تشکیل شورای انقلاب (1357ه.ش)", "", "", "", "فرار شاه (1357 ه.ش)", "", "", "روز غزه", ""};

    boolean dey2[] = {true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false};

    String bahman[] = {"زادروز فردوسی", "بهمن روز، جشن بهمنگان", "", "", "انتخابات اولین دوره ریاست جمهوری(1358ه.ش)  ; جشن نوسره", "سالروز حماسه مردم آمل", "", "", "",
            "جشن سده", "", "بازشگت امام خمینی به ایران و آغاز دهه فجر", "", "روز فناوری فضایی", "جشن میانه زمستان", "", "", "",
            "روز نیروی هوایی", "", "شکسته شدن حکومت نظامی به فرمان امام خمینی (1357ه.ش)", "پیروزی انقلاب اسلامی و سقوط نظام شاهنشاهی (1357ه.ش)", "", "", "صدور حکم امام خمینی مبنی بر ارتداد سلمان رشدی (1367ه.ش)",
            "", "", "", "قیام مردم تبریز(1356ه.ش)   ; روز اقتصاد مقاومتی و کارآفرینی", ""};

    boolean bahman2[] = {false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, true, false, false, false, false, true, false, false, false};

    String esfand[] = {"شهادت حضرت فاطمه زهرا(11ه.ق)", "", "کودتای رضاخان(1299ه.ش)", "", "روز بزرگداشت خواجه نصیرالدین طوسی  ; روز مهندسی", "", "",
            "روز امور تربیتی و تربیت اسلامی", "روز ملی حمایت از حقوق مصرف کنندگان", "جشن وخشنکام", "", "", "", "روز احسان و نیکوکاری", "روز درختکاری", "", "", "روز بزرگداشت سید جمال الدین اسدآبادی  ; سالروز تاسیس کانون های فرهنگی و هنری مساجد کشور",
            "جشن نوروز رودها", "روز راهیان نور  ; جشن گلدان", "روز بزرگداشت نظامی گنجوی", "روز بزرگداشت شهدا - تاسیس بنیاد شهید انقلاب اسلامی (1358ه.ش)", "",
            "برگزاری انتخابات اولین دوره مجلس شورای اسلامی (1358ه.ش)", "روز بزرگداشت پروین اعتصامی  ; بمباران شیمیایی حلبچه توسط ارتش بعث عراق (1366ه.ش)",
            "", "", "", "روز ملی شدن صنعت نفت ایران (1329ه.ش)"};

    boolean esfand2[] = {true, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true,
            false, false, false, false, false, false, true, false, false, false, true};

    String notBefore1395 = "این تقویم فقط رویداد های سال 1396 را پشتیبانی میکند";
    String getUpdate = "برای رویداد های سال آینده قبل از شروع سال جدید آپدیت جدید برنامه ما را دانلود فرمایید";


    public static int g_days_in_month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static int j_days_in_month[] = { 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29 };

    private int year;
    private int tyear;
    private int day;
    private int month;
    private int tmonth;

    TextView lastDay;
    ArrayList<TextView> days;

    float xs,xe;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lastDay = findViewById(R.id.Fri6);
        days=new <TextView>ArrayList();
        TextView dayy=findViewById(R.id.Sat1);

        days.add(0,dayy);
        dayy=findViewById(R.id.Sun1);
        days.add(1,dayy);
        dayy=findViewById(R.id.Mon1);
        days.add(2,dayy);
        dayy=findViewById(R.id.Tue1);
        days.add(3,dayy);
        dayy=findViewById(R.id.Wed1);
        days.add(4,dayy);
        dayy=findViewById(R.id.Thu1);
        days.add(5,dayy);
        dayy=findViewById(R.id.Fri1);
        days.add(6,dayy);
        dayy=findViewById(R.id.Sat2);
        days.add(7,dayy);
        dayy=findViewById(R.id.Sun2);
        days.add(8,dayy);
        dayy=findViewById(R.id.Mon2);
        days.add(9,dayy);
        dayy=findViewById(R.id.Tue2);
        days.add(10,dayy);
        dayy=findViewById(R.id.Wed2);
        days.add(11,dayy);
        dayy=findViewById(R.id.Thu2);
        days.add(12,dayy);
        dayy=findViewById(R.id.Fri2);
        days.add(13,dayy);
        dayy=findViewById(R.id.Sat3);
        days.add(14,dayy);
        dayy=findViewById(R.id.Sun3);
        days.add(15,dayy);
        dayy=findViewById(R.id.Mon3);
        days.add(16,dayy);
        dayy=findViewById(R.id.Tue3);
        days.add(17,dayy);
        dayy=findViewById(R.id.Wed3);
        days.add(18,dayy);
        dayy=findViewById(R.id.Thu3);
        days.add(19,dayy);
        dayy=findViewById(R.id.Fri3);
        days.add(20,dayy);
        dayy=findViewById(R.id.Sat4);
        days.add(21,dayy);
        dayy=findViewById(R.id.Sun4);
        days.add(22,dayy);
        dayy=findViewById(R.id.Mon4);
        days.add(23,dayy);
        dayy=findViewById(R.id.Tue4);
        days.add(24,dayy);
        dayy=findViewById(R.id.Wed4);
        days.add(25,dayy);
        dayy=findViewById(R.id.Thu4);
        days.add(26,dayy);
        dayy=findViewById(R.id.Fri4);
        days.add(27,dayy);
        dayy=findViewById(R.id.Sat5);
        days.add(28,dayy);
        dayy=findViewById(R.id.Sun5);
        days.add(29,dayy);
        dayy=findViewById(R.id.Mon5);
        days.add(30,dayy);
        dayy=findViewById(R.id.Tue5);
        days.add(31,dayy);
        dayy=findViewById(R.id.Wed5);
        days.add(32,dayy);
        dayy=findViewById(R.id.Thu5);
        days.add(33,dayy);
        dayy=findViewById(R.id.Fri5);
        days.add(34,dayy);
        dayy=findViewById(R.id.Sat6);
        days.add(35,dayy);
        dayy=findViewById(R.id.Sun6);
        days.add(36,dayy);
        dayy=findViewById(R.id.Mon6);
        days.add(37,dayy);
        dayy=findViewById(R.id.Tue6);
        days.add(38,dayy);
        dayy=findViewById(R.id.Wed6);
        days.add(39,dayy);
        dayy=findViewById(R.id.Thu6);
        days.add(40,dayy);
        dayy=findViewById(R.id.Fri6);
        days.add(41,dayy);

        int i=0;
        for (;i<42;i++){
            days.get(i).setText(" ");
            days.get(i).setBackgroundDrawable(getDrawable(R.drawable.txt_border2));
        }

        findViewById(R.id.taqvim).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xs = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        xe = event.getX();
                        if ((xe - xs) > 0) {
                            if (month==12){
                                month=1;
                                year++;
                            }
                            else{
                                month++;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideright));


                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        else if ((xe - xs) < 0){
                            if (month==1){
                                month=12;
                                year--;
                            }
                            else{
                                month--;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideleft));


                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        break;
                }
                return true;
            }
        });
        MyCalendar jc = new MyCalendar();
        tyear = jc.getYear();
        year = jc.getYear();
        tmonth = jc.getMonth();
        month = jc.getMonth();
        day = jc.getDay();
        showCalendarfirst(tyear,tmonth,day);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickToday(View button){
        showCalendarfirst(tyear,tmonth,day);
        year=tyear;
        month=tmonth;
        Button today = findViewById(R.id.todaybutt);
        today.setVisibility(Button.INVISIBLE);

        findViewById(R.id.taqvim).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xs = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        xe = event.getX();
                        if ((xe - xs) > 0) {
                            if (month==12){
                                month=1;
                                year++;
                            }
                            else{
                                month++;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideright));
                            //AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();

                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        else if ((xe - xs) < 0){
                            if (month==1){
                                month=12;
                                year--;
                            }
                            else{
                                month--;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideleft));
                            // AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();

                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        break;
                }
                return true;
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClicknext(View view){
        if (month==12){
            month=1;
            year++;
        }
        else{
            month++;
        }
        LinearLayout taqvim=findViewById(R.id.taqvim);
        taqvim.setBackground(getDrawable(R.drawable.sideright));
        AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
        // anim.start();

        showCalendar(year,month,day);
        Button today = findViewById(R.id.todaybutt);
        today.setVisibility(Button.VISIBLE);


        findViewById(R.id.taqvim).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xs = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        xe = event.getX();
                        if ((xe - xs) > 0) {
                            if (month==12){
                                month=1;
                                year++;
                            }
                            else{
                                month++;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideright));


                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);
                        }
                        else if ((xe - xs) < 0){
                            if (month==1){
                                month=12;
                                year--;
                            }
                            else{
                                month--;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideleft));
                            // AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();

                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        break;
                }
                return true;
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickpre(View view){
        if (month==1){
            month=12;
            year--;
        }
        else{
            month--;
        }
        LinearLayout taqvim=findViewById(R.id.taqvim);
        taqvim.setBackground(getDrawable(R.drawable.sideleft));
        //AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
        //anim.start();
        showCalendar(year,month,day);

        Button today = findViewById(R.id.todaybutt);
        today.setVisibility(Button.VISIBLE);


        findViewById(R.id.taqvim).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xs = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        xe = event.getX();
                        if ((xe - xs) > 0) {
                            if (month==12){
                                month=1;
                                year++;
                            }
                            else{
                                month++;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideright));
                            //AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();
                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        else if ((xe - xs) < 0){
                            if (month==1){
                                month=12;
                                year--;
                            }
                            else{
                                month--;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideleft));
                            // AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();
                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        break;
                }
                return true;
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClickrooz(View view){
        int shoro=(int)modeleMah(year,month);
        TextView rooz=findViewById(view.getId());
        CharSequence r=rooz.getText();
        String b=r.toString();
        if (b==" "){
            return;
        }
        if (rooz==lastDay){
            //rooz.setVisibility(View.INVISIBLE);

        }
        lastDay=rooz;
        showCalendar(year,month,day);

        rooz.setBackground(getDrawable(R.drawable.circle_select_light));
        int roz=Integer.parseInt(b);
        events(year, month, roz);
        TextView jalaliShow=(TextView) findViewById(R.id.jalali_date);
        jalaliShow.setText(roz+" "+jmonths[month-1]+" "+year);
        jalaliShow.setVisibility(View.VISIBLE);
        Calendar gre=convertJalaliToGregorian(year,month,roz);
        TextView gregorianShow=(TextView) findViewById(R.id.gregorian_date);
        gregorianShow.setText(gre.get(Calendar.YEAR)+"/"+months[gre.get(Calendar.MONTH)]+"/"+gre.get(Calendar.DAY_OF_MONTH));
        gregorianShow.setVisibility(View.VISIBLE);
        double[] hijriDate=kuwaiticalendar(gre);
        TextView hijriShow=(TextView) findViewById(R.id.hijri_date);
        hijriShow.setText((int)hijriDate[5]+ "/" + aMonths[(int) hijriDate[6]] + "/" + (int) hijriDate[7] );
        hijriShow.setVisibility(View.VISIBLE);

        if(roz!=day){
            Button today = findViewById(R.id.todaybutt);
            today.setVisibility(Button.VISIBLE);
        }

        findViewById(R.id.taqvim).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xs = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        xe = event.getX();
                        if ((xe - xs) > 0) {
                            if (month==12){
                                month=1;
                                year++;
                            }
                            else{
                                month++;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideright));
                            //AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();
                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        else if ((xe - xs) < 0){
                            if (month==1){
                                month=12;
                                year--;
                            }
                            else{
                                month--;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideleft));
                            // AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();
                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);

                        }
                        break;
                }
                return true;
            }
        });
    }
    static double gmod(double n,double  m) {
        return ((n % m) + m) % m;
    }
    static double[] kuwaiticalendar(Calendar today) {
        boolean adjust=true;
        int adj=0;
        if(adjust){
            adj=0;
        }else{
            adj=1;
        }

        if (adjust) {
            int adjustmili = 1000 * 60 * 60 * 24 * adj;
            long todaymili = today.getTimeInMillis() + adjustmili;
            today.setTimeInMillis(todaymili);
        }
        double day = today.get(Calendar.DAY_OF_MONTH);
        double  month = today.get(Calendar.MONTH);
        double  year = today.get(Calendar.YEAR);

        double  m = month + 1;
        double  y = year;
        if (m < 3) {
            y -= 1;
            m += 12;
        }

        double a = Math.floor(y / 100.);
        double b = 2 - a + Math.floor(a / 4.);

        if (y < 1583)
            b = 0;
        if (y == 1582) {
            if (m > 10)
                b = -10;
            if (m == 10) {
                b = 0;
                if (day > 4)
                    b = -10;
            }
        }

        double jd = Math.floor(365.25 * (y + 4716)) + Math.floor(30.6001 * (m + 1)) + day
                + b - 1524;

        b = 0;
        if (jd > 2299160) {
            a = Math.floor((jd - 1867216.25) / 36524.25);
            b = 1 + a - Math.floor(a / 4.);
        }
        double bb = jd + b + 1524;
        double cc = Math.floor((bb - 122.1) / 365.25);
        double dd = Math.floor(365.25 * cc);
        double ee = Math.floor((bb - dd) / 30.6001);
        day = (bb - dd) - Math.floor(30.6001 * ee);
        month = ee - 1;
        if (ee > 13) {
            cc += 1;
            month = ee - 13;
        }
        year = cc - 4716;

        double wd = gmod(jd + 1, 7) + 1;

        double iyear = 10631. / 30.;
        double epochastro = 1948084;
        double epochcivil = 1948085;

        double shift1 = 8.01 / 60.;

        double z = jd - epochastro;
        double cyc = Math.floor(z / 10631.);
        z = z - 10631 * cyc;
        double j = Math.floor((z - shift1) / iyear);
        double iy = 30 * cyc + j;
        z = z - Math.floor(j * iyear + shift1);
        double im = Math.floor((z + 28.5001) / 29.5);
        if (im == 13)
            im = 12;
        double id = z - Math.floor(29.5001 * im - 29);

        double[]  myRes = new double[8];

        myRes[0] = day; // calculated day (CE)
        myRes[1] = month - 1; // calculated month (CE)
        myRes[2] = year; // calculated year (CE)
        myRes[3] = jd - 1; // julian day number
        myRes[4] = wd - 1; // weekday number
        myRes[5] = id; // islamic date
        myRes[6] = im - 1; // islamic month
        myRes[7] = iy; // islamic year

        return myRes;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showCalendarfirst(int yearr , int mont,int dayy){
        events(yearr, mont, dayy);
        int i=0;
        for (;i<42;i++){
            days.get(i).setText(" ");
            days.get(i).setBackgroundDrawable(getDrawable(R.drawable.txt_border2));
        }
        TextView yearmonth=(TextView) findViewById(R.id.year_month);
//        TextView invalid=(TextView) findViewById(R.id.invalid_inputs);
//        invalid.setVisibility(View.INVISIBLE);

        if (mont>12){
//            invalid.setVisibility(View.VISIBLE);
        }
        else {
            int shoro=(int)modeleMah(yearr,mont);
            int monthlong=j_days_in_month[mont-1];
            yearmonth.setText("("+jmonths[mont-1]+")"+yearr+"/"+mont);
            Calendar tarikh=convertJalaliToGregorian(yearr,mont,1);
            boolean isLeapYear = ((tarikh.get(Calendar.YEAR)+3)%4 == 0 && (tarikh.get(Calendar.YEAR)+3)%100 != 0 || (tarikh.get(Calendar.YEAR)+3)%400 == 0);
            if (mont==12 && isLeapYear){monthlong++;}
            i = 1;

            for (; i < monthlong + 1; i++) {

                days.get(shoro).setText("" + i);
                days.get(shoro).setTextColor(getResources().getColor(R.color.dark));
                days.get(shoro).setBackground(getDrawable(R.drawable.txt_border));
                if (i==dayy){
                    days.get(shoro).setBackground(getDrawable(R.drawable.circle_current_day_light));
                    // rooza.get(shoro).setBackgroundColor(day);
                    TextView jalaliShow=(TextView) findViewById(R.id.jalali_date);
                    jalaliShow.setText(dayy+" "+jmonths[mont-1]+" "+yearr);
                    jalaliShow.setVisibility(View.VISIBLE);
                    Calendar gre=convertJalaliToGregorian(yearr,mont,dayy);
                    TextView gregorianShow=(TextView) findViewById(R.id.gregorian_date);
                    gregorianShow.setText(gre.get(Calendar.YEAR)+"/"+months[gre.get(Calendar.MONTH)]+"/"+gre.get(Calendar.DAY_OF_MONTH));
                    gregorianShow.setVisibility(View.VISIBLE);
                    double[] hijriDate=kuwaiticalendar(gre);
                    TextView hijriShow=(TextView) findViewById(R.id.hijri_date);
                    hijriShow.setText((int)hijriDate[5]+ "/" + aMonths[(int) hijriDate[6]] + "/" + (int) hijriDate[7] );
                    hijriShow.setVisibility(View.VISIBLE);
                }
                shoro++;
            }


            shoro=(int)modeleMah(yearr,mont);
            i=1;
            for (; i < monthlong + 1; i++) {

                days.get(shoro).setText("" + i);
                if (mont == 1) {
                    if (farvardin2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 2) {
                    if (ordibehesht2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 3) {
                    if (khordad2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 4) {
                    if (tir2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 5) {
                    if (mordad2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 6) {
                    if (shahrivar2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 7) {
                    if (mehr2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 8) {
                    if (aban2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 9) {
                    if (azar2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 10) {
                    if (dey2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 11) {
                    if (bahman2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else if (mont == 12) {
                    if (esfand2[i - 1]) {
                        days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                }
                days.get(shoro).setBackground(getDrawable(R.drawable.txt_border));
                if (i==dayy){
                    days.get(shoro).setBackground(getDrawable(R.drawable.circle_current_day_light));
                    // rooza.get(shoro).setBackgroundColor(day);
                    TextView jalaliShow=(TextView) findViewById(R.id.jalali_date);
                    jalaliShow.setText(dayy+" "+jmonths[mont-1]+" "+yearr);
                    jalaliShow.setVisibility(View.VISIBLE);
                    Calendar gre=convertJalaliToGregorian(yearr,mont,dayy);
                    TextView gregorianShow=(TextView) findViewById(R.id.gregorian_date);
                    gregorianShow.setText(gre.get(Calendar.YEAR)+"/"+months[gre.get(Calendar.MONTH)]+"/"+gre.get(Calendar.DAY_OF_MONTH));
                    gregorianShow.setVisibility(View.VISIBLE);
                    double[] hijriDate=kuwaiticalendar(gre);
                    TextView hijriShow=(TextView) findViewById(R.id.hijri_date);
                    hijriShow.setText((int)hijriDate[5]+ "/" + aMonths[(int) hijriDate[6]] + "/" + (int) hijriDate[7] );
                    hijriShow.setVisibility(View.VISIBLE);
                }
                shoro++;
            }
        }



        findViewById(R.id.taqvim).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xs = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        xe = event.getX();
                        if ((xe - xs) > 0) {
                            if (month==12){
                                month=1;
                                year++;
                            }
                            else{
                                month++;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideright));
                            //AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();
                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);
                        }
                        else if ((xe - xs) < 0){
                            if (month==1){
                                month=12;
                                year--;
                            }
                            else{
                                month--;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideleft));
                            // AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();
                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);
                        }
                        break;
                }
                return true;
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showCalendar(int yearr , int mont,int dayy){
        int i=0;
        for (;i<42;i++){
            days.get(i).setText(" ");
            days.get(i).setBackgroundDrawable(getDrawable(R.drawable.txt_border2));
        }
        TextView yearmonth=(TextView) findViewById(R.id.year_month);
//        TextView invalid=(TextView) findViewById(R.id.invalid_inputs);
//        invalid.setVisibility(View.INVISIBLE);

        if (mont>12){
//            invalid.setVisibility(View.VISIBLE);
        }
        else {
            int shoro=(int)modeleMah(yearr,mont);
            int monthlong=j_days_in_month[mont-1];
            yearmonth.setText("("+jmonths[mont-1]+")"+yearr+"/"+mont);
            Calendar tarikh=convertJalaliToGregorian(yearr,mont,1);
            boolean isLeapYear = ((tarikh.get(Calendar.YEAR)+3)%4 == 0 && (tarikh.get(Calendar.YEAR)+3)%100 != 0 || (tarikh.get(Calendar.YEAR)+3)%400 == 0);
            if (mont==12 && isLeapYear){monthlong++;}
            i = 1;


            for (; i < monthlong + 1; i++) {

                days.get(shoro).setText("" + i);

                days.get(shoro).setTextColor(getResources().getColor(R.color.dark));
                days.get(shoro).setBackgroundDrawable(getDrawable(R.drawable.txt_border));
                if ((tmonth==mont) && (tyear==yearr) && (i==dayy)){
                    days.get(shoro).setBackground(getDrawable(R.drawable.circle_current_day_light));
                    // rooza.get(shoro).setBackgroundColor(day);
                    TextView jalaliShow=(TextView) findViewById(R.id.jalali_date);
                    jalaliShow.setText(dayy+" "+jmonths[mont-1]+" "+yearr);
                    jalaliShow.setVisibility(View.VISIBLE);
                    Calendar gre=convertJalaliToGregorian(yearr,mont,dayy);
                    TextView gregorianShow=(TextView) findViewById(R.id.gregorian_date);
                    gregorianShow.setText(gre.get(Calendar.YEAR)+"/"+months[gre.get(Calendar.MONTH)]+"/"+gre.get(Calendar.DAY_OF_MONTH));
                    gregorianShow.setVisibility(View.VISIBLE);
                    double[] hijriDate=kuwaiticalendar(gre);
                    TextView hijriShow=(TextView) findViewById(R.id.hijri_date);
                    hijriShow.setText((int)hijriDate[5]+ "/" + aMonths[(int) hijriDate[6]] + "/" + (int) hijriDate[7] );
                    hijriShow.setVisibility(View.VISIBLE);
                    events(yearr, mont, dayy);
                }
                shoro++;
            }

            shoro=(int)modeleMah(yearr,mont);
            i=1;
            if (yearr == 1396) {
                for (; i < monthlong + 1; i++) {

                    days.get(shoro).setText("" + i);

                    if (mont == 1) {
                        if (farvardin2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 2) {
                        if (ordibehesht2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 3) {
                        if (khordad2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 4) {
                        if (tir2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 5) {
                        if (mordad2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 6) {
                        if (shahrivar2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 7) {
                        if (mehr2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 8) {
                        if (aban2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 9) {
                        if (azar2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 10) {
                        if (dey2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 11) {
                        if (bahman2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    } else if (mont == 12) {
                        if (esfand2[i - 1]) {
                            days.get(shoro).setTextColor(getResources().getColor(R.color.colorAccent));
                        }
                    }
                    days.get(shoro).setBackgroundDrawable(getDrawable(R.drawable.txt_border));
                    if ((tmonth==mont) && (tyear==yearr) && (i==dayy)){
                        days.get(shoro).setBackground(getDrawable(R.drawable.circle_current_day_light));
                        // rooza.get(shoro).setBackgroundColor(day);
                        TextView jalaliShow=(TextView) findViewById(R.id.jalali_date);
                        jalaliShow.setText(dayy+" "+jmonths[mont-1]+" "+yearr);
                        jalaliShow.setVisibility(View.VISIBLE);
                        Calendar gre=convertJalaliToGregorian(yearr,mont,dayy);
                        TextView gregorianShow=(TextView) findViewById(R.id.gregorian_date);
                        gregorianShow.setText(gre.get(Calendar.YEAR)+"/"+months[gre.get(Calendar.MONTH)]+"/"+gre.get(Calendar.DAY_OF_MONTH));
                        gregorianShow.setVisibility(View.VISIBLE);
                        double[] hijriDate=kuwaiticalendar(gre);
                        TextView hijriShow=(TextView) findViewById(R.id.hijri_date);
                        hijriShow.setText((int)hijriDate[5]+ "/" + aMonths[(int) hijriDate[6]] + "/" + (int) hijriDate[7] );
                        hijriShow.setVisibility(View.VISIBLE);
                        events(yearr, mont, dayy);
                    }
                    shoro++;
                }
            }

        }


        findViewById(R.id.taqvim).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xs = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        xe = event.getX();
                        if ((xe - xs) > 0) {
                            if (month==12){
                                month=1;
                                year++;
                            }
                            else{
                                month++;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideright));
                            //AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();

                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);
                        }
                        else if ((xe - xs) < 0){
                            if (month==1){
                                month=12;
                                year--;
                            }
                            else{
                                month--;
                            }
                            LinearLayout taqvim=findViewById(R.id.taqvim);
                            taqvim.setBackground(getDrawable(R.drawable.sideleft));
                            // AnimationDrawable anim= (AnimationDrawable) taqvim.getBackground();
                            //anim.start();

                            Button today = findViewById(R.id.todaybutt);
                            today.setVisibility(Button.VISIBLE);
                            showCalendar(year,month,day);
                        }
                        break;
                }
                return true;
            }
        });
    }

    private long modeleMah(int sall,int mahh){
        Calendar mabda=convertJalaliToGregorian(1,1,1);
        Calendar tarikh=convertJalaliToGregorian(sall,mahh,1);
        long millis1 = mabda.getTimeInMillis();
        long millis2 = tarikh.getTimeInMillis();
        long diff = millis2 - millis1;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long a=diffDays%7-3;
        if (a<0){
            a=a+7;
        }
        return a;
    }

    private Calendar convertJalaliToGregorian(int year, int month, int day) {

        int gy, gm, gd;
        int jy, jm, jd;
        long g_day_no, j_day_no;
        boolean leap;

        int i;

        jy = year - 979;
        jm = month - 1;
        jd = day - 1;

        j_day_no = 365 * jy + (jy / 33) * 8 + (jy % 33 + 3) / 4;
        for (i = 0; i < jm; ++i)
            j_day_no += j_days_in_month[i];

        j_day_no += jd;

        g_day_no = j_day_no + 79;

        gy = (int) (1600 + 400 * (g_day_no / 146097));
        g_day_no = g_day_no % 146097;

        leap = true;
        if (g_day_no >= 36525)
        {
            g_day_no--;
            gy += 100 * (g_day_no / 36524);
            g_day_no = g_day_no % 36524;

            if (g_day_no >= 365)
                g_day_no++;
            else
                leap = false;
        }

        gy += 4 * (g_day_no / 1461);
        g_day_no %= 1461;

        if (g_day_no >= 366) {
            leap = false;

            g_day_no--;
            gy += g_day_no / 365;
            g_day_no = g_day_no % 365;
        }

        for (i = 0; g_day_no >= g_days_in_month[i]
                + booleanToInt(i == 1 && leap); i++)
            g_day_no -= g_days_in_month[i] + booleanToInt(i == 1 && leap);

        gm = i + 1;
        gd = (int) (g_day_no + 1);

        GregorianCalendar gregorian = new  GregorianCalendar(gy, gm - 1, gd);
        return gregorian;
    }

    private static int booleanToInt(Boolean sample) {
        if (sample)
            return 1;
        else
            return 0;
    }


    private void events(int y,int m , int d){
        TextView events = findViewById(R.id.events);
        if (y<=1395){
            events.setText(notBefore1395);
        } else if (y >= 1397) {
            events.setText(getUpdate);
        } else if (y == 1396) {
            if (m == 1) {
                events.setText(farvardin[d-1]);
            } else if (m == 2) {
                events.setText(ordibehesht[d-1]);
            } else if (m == 3) {
                events.setText(khordad[d-1]);
            } else if (m == 4) {
                events.setText(tir[d-1]);
            } else if (m == 5) {
                events.setText(mordad[d-1]);
            } else if (m == 6) {
                events.setText(shahrivar[d-1]);

            } else if (m == 7) {
                events.setText(mehr[d-1]);
            } else if (m == 8) {
                events.setText(aban[d-1]);
            } else if (m == 9) {
                events.setText(azar[d-1]);

            } else if (m == 10) {
                events.setText(dey[d-1]);
            } else if (m == 11) {
                events.setText(bahman[d-1]);
            } else if (m == 12) {
                events.setText(esfand[d-1]);
            }
        }
    }

}
