package com.murdock.quizapp;

public class Quiz1 {
    public static String questions[] = {
        "Although most people’s first thought when they think of Android is Google, Android is not actually owned by Google. Who owns the Android platform?",
        "Android tries hard to ______________ low-level components, such as the software stack, with interfaces so that vendor-specific code can be managed easily.",
        "What file is responsible for gluing everything together , explaining what the application consists of, what its main building blocks are, ext…?",
        "Broadcast receivers are Android’s implementation of a system-wide publish/subscribe mechanism, or more precisely, what design pattern?",
        "The android OS comes with many useful system services, which include processes you can easily ask for things such as your..."
    };

    public static String options[][] = {
            {"oracle technology", "dalvik", "open handset alliance", "android is owned by google"},
            {"confound", "abstract", "modularize", "compound"},
            {"layout file", "strings xml,", "r file,", "manifest file"},
            {"observer", "facade", "mediator", "command"},
            {"all of these and more", "location", "sensor readings", "wifi? hot spots"}
    };

    public static String answers[] = {
            "open handset alliance", "abstract", "manifest file", "observer", "all of these and more"
    };
}
