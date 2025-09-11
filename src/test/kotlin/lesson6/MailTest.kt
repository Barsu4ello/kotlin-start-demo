package lesson6

import lesson6.mail.Client
import lesson6.mail.Mailer
import lesson6.mail.PersonalInfo
import lesson6.mail.sendMessageTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.verifyNoMoreInteractions

class MailTest {

    @Test
    @DisplayName("sendMessageTo() должен вызывать mailer.sendMessage с правильными параметрами")
    fun sendMessageToWithRightParameters() {
        val mailer = Mockito.mock(Mailer::class.java)

        sendMessageTo(Client(PersonalInfo("email")), "message", mailer)

        Mockito.verify(mailer).sendMessage("email", "message")
    }

    @Test
    @DisplayName("sendMessageTo() не должен вызывать mailer.sendMessage с неправильными параметрами")
    fun sendMessageToWithWrongParameters() {
        val mailer = Mockito.mock(Mailer::class.java)

        sendMessageTo(Client(PersonalInfo("email")), null, mailer)

        Mockito.verify(mailer, Mockito.never()).sendMessage(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())
        // или можно сделать через verifyNoMoreInteractions
        verifyNoMoreInteractions(mailer)
    }
}