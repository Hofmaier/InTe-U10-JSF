package ch.hsr.ratespiel;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="locale")
@SessionScoped
public class LocaleBean {
	
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	
	public LocaleBean(){
		System.out.println("[LocaleBean] ich lebe: "  + locale.getLanguage());
	}

	public String getLocale() {
		//System.out.println("[LocaleBean] getLocale: " + locale.getLanguage());
		return locale.getLanguage();
		//return FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
	}

	public void setLocale(String locale) {
		System.out.println("[LocaleBean] setLocale: " + locale);
		this.locale = new Locale(locale);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
	}
	
	public void localeChangeListener(ValueChangeEvent ev){
		String locale = (String) ev.getNewValue();
		setLocale(locale);
		FacesContext.getCurrentInstance().renderResponse();
	}
}
