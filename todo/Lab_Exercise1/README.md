# Form Exercise with Sessions

## 1. Create the Web Application

Create a Web Application in IntelliJ, using Tomcat as the server. 
<br>

> [!NOTE]
> Download and setup Tomcat as instructed in last weeks lecture.

<br>

Add an `index.jsp` page to the project. One should be automatically added to the project when it is created.
<br><br>
## 2. Create the Registration Form


Remove all the code `index.jsp` page and replace it with the following:

```html
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Please Send Us Your Details</title>
</head>

<body>

<form id="detailsForm" name="detailsForm" method="????" action="??????">

    <h2>Please Send Us Your Details.</h2>

    <table width="730" border="0">

        <tr>
            <td width="266">Name</td>
            <td width="454">
                <input name="name" type="text" id="name" size="50" />
            </td>
        </tr>

        <tr>
            <td height="31">Address</td>
            <td>
                <input name="address" type="text" id="address" size="50" />
            </td>
        </tr>

        <tr>
            <td>City</td>
            <td>
                <input type="text" name="city" id="city" />
            </td>
        </tr>

        <tr>
            <td>Country</td>
            <td>
                <input type="text" name="country" id="country" />
            </td>
        </tr>

        <tr>
            <td>Phone</td>
            <td>
                <input type="text" name="phone" id="phone" />
            </td>
        </tr>

        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" id="email" />
            </td>
        </tr>

        <tr>
            <td>EU Status</td>
            <td>
                <label>EU</label>
                <input type="radio" id="eu" name="eu" value="eu">

                <label>Non EU</label>
                <input type="radio" id="noneu" name="eu" value="noneu">
            </td>
        </tr>

        <tr>
            <td>How Did You Hear About Us?</td>
            <td>
                Twitter
                <input name="check" type="checkbox" id="twitter" value="twitter">

                Facebook
                <input name="check" type="checkbox" id="facebook" value="facebook">

                Newspaper
                <input name="check" type="checkbox" id="newspaper" value="newspaper">

                Radio
                <input name="check" type="checkbox" id="radio" value="radio">

                Other
                <input name="check" type="checkbox" id="other" value="other">
            </td>
        </tr>

        <tr>
            <td>Comments</td>
            <td>
                <textarea name="comments" id="comments" cols="45" rows="5"></textarea>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" name="submit" id="submit" value="Submit" />
            </td>
            <td>
                <input type="reset" name="clear" id="clear" value="Clear" />
            </td>
        </tr>

    </table>

</form>

</body>
</html>
```

The form allows users to register their personal details with the site. And looks like the following:

<br>

|![image](https://github.com/user-attachments/assets/683d3a16-f02f-4175-8178-ec1a8fb41a10)|
|:--------------------------------------------------------------------------------------:|
| **Fig 1. Index page for the application.**|



<br><br>

## 3. Handle the Form Submission

When the form is submitted, a JSP is called that acknowledges the user's submission of the form and provides a link so that the user can review the details that they submitted.

You must write this JSP.

A screen grab of what it might look like is shown below.


|![image](https://github.com/user-attachments/assets/bfd46fea-cdd4-4b18-9229-4fbee2bcb521)|
|:--------------------------------------------------------------------------------------:|
| **Fig 2. Confirmation Page.**|

<br><br>

## 4. Display the Submitted Details

When the user clicks on the link, a JSP is called that displays the details that the user entered into the original form.

You must also write this JSP.

This page provides two buttons (implement them as links if you like).


|![image](https://github.com/user-attachments/assets/cb32f960-af28-48f2-b4fc-0cbc96749220)|
|:--------------------------------------------------------------------------------------:|
|**Fig 3. Page to allow the user to view their details again.**|

<br><br>

## 5. Edit Details

One button, **Edit Details**, will return the user to the index page where the form will once again be presented to the user.

However, it will be populated with the user's data. From there they can edit their details should they wish to.


|![image](https://github.com/user-attachments/assets/b37593d5-dd41-4661-b19c-e7c96f0eec86)|
|:--------------------------------------------------------------------------------------:|
|**Fig 4. Index page redisplayed with the user's original input.**|

<br><br>

## 6. Save Details
If the user clicks on the second button, **Save Details**, from the **Details Confirmation Page**, the user's details will be saved to a file and a "thank you" page will be displayed.




|![image](https://github.com/user-attachments/assets/79bc2970-354d-4fda-861b-1f99901b0f0a)|
|:--------------------------------------------------------------------------------------:|
|**Fig 5. Thanks Page.**|

<br><br>

## 7. Return Home

From the "thank you" page, the user will be afforded the option to go **HOME** (the index page).

Should the user click on this button, the index page will again be displayed, but the fields within the form should be empty.



|![image](https://github.com/user-attachments/assets/1d297383-d054-4130-bf1a-e7c296e01a6a)|
|:--------------------------------------------------------------------------------------:|
|**Fig 6. Contents of the file after the user's details have been saved.**|


