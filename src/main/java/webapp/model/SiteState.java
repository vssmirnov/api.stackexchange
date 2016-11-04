package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public enum SiteState {
    /// <summary>
    /// normal
    /// </summary>
    normal,

    /// <summary>
    /// closed_beta
    /// </summary>
    closed_beta,

    /// <summary>
    /// open_beta
    /// </summary>
    open_beta,

    /// <summary>
    /// linked_meta
    /// </summary>
    linked_meta
}
