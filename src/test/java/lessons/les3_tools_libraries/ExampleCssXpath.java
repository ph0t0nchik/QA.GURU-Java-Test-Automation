package lessons.les3_tools_libraries;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ExampleCssXpath {
    void cssXpathExample(){
        // <input autocomplete="off" placeholder="name@example.com" type="email" id="userEmail" class="mr-sm-2 form-control">
        $("[id=userEmail]").setValue("1");
//        $("[#userEmail]").setValue("1");
        $(by("id", "userEmail")).setValue("1");
        $x("//*[@id='userEmail']").setValue("1");
        $(byXpath("//*[@id='userEmail']")).setValue("1");

        // <input type="email" class="mr-sm-2 form-control">
        $(".mr-sm-2.form-control").setValue("1");
        $("input.mr-sm-2.form-control").setValue("1");
        $x("//input[@class='mr-sm-2'][@class='form-control']").setValue("1");

        //<div class="mr-sm-2">
        // <input type="email" class="form-control">
        //</div>
        $(".mr-sm-2.form-control").setValue("1");
        $("div.mr-sm-2 input.form-control").setValue("1");

        //<div>Hello, qa.guru</div>
        $x("//div[text()='Hello, qa.guru!']").click();
        $(byText("Hello, qa.guru!"));
        $(withText(", qa.guru!"));
    }
}
