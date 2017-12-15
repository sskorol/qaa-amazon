package io.github.sskorol.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

import static io.qameta.allure.Allure.addAttachment;

/**
 * Attachments processing class. Use it along with Allure annotations.
 */
@SuppressWarnings({"HideUtilityClassConstructor", "PMD.UseUtilityClass"})
@UtilityClass
public class AttachmentUtils {

    public static void attachUri(final String name, final String data) {
        addAttachment(name, "text/uri-list", data);
    }

    @Attachment(value = "{name}", type = "text/plain")
    public static String attachLog(final String name, final String data) {
        return data;
    }

    @Attachment(value = "{name}", type = "image/png")
    public static byte[] attachScreenshot(final byte[] bytes, final String name) {
        return bytes;
    }
}
